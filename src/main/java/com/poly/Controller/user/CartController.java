package com.poly.Controller.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poly.DAO.DiscountsDAO;
import com.poly.DAO.ProductsDAO;
import com.poly.Entities.Products;
import com.poly.service.B64Session;
import com.poly.service.CartItem;

@Controller
public class CartController {
	@Autowired
	HttpSession session;
	@Autowired
	ProductsDAO productRepo;
	@Autowired
	HttpServletRequest request;

	@Autowired
	DiscountsDAO discountRepo;
	@Autowired
	B64Session b64s;
	@GetMapping("/user/cart")
	public String view(Model model) {
		model.addAttribute("username", b64s.getUserName());	
		model.addAttribute("userLogin", b64s.getUserLogin());	
		Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartItem>();
		} else {
			model.addAttribute("listCart", cart);
		}

		return "user/cart";
	}
	@GetMapping("/user/order")
	public String view2() {
		// giỏ hàng
		return "/admin/product";
	}

	@PostMapping("/delete/cart")
	public String delete(Model model, @RequestBody CartItem test) {
		System.out.println("Số lương input hiện tại"+test.getQuantity());
		int id = test.getId();
		System.out.println("Du lieu truyen qua: " + test.getId());

		Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartItem>();
		} else {

			float total = (float) session.getAttribute("total");
			int cartNumber = (int) session.getAttribute("cartSize");
			float price = (float) (total - (cart.get(id).getPrice() * test.getQuantity()));
			cart.remove(id);
			cartNumber--;
			session.setAttribute("cartSize", cartNumber);
			session.setAttribute("cart", cart);
			session.setAttribute("total", price);
			System.out.println(session.getAttribute("total"));

		}

		return "user/cart";
	}

	//

	/// trừ đi số lượng có trong sản phẩm
	// luu thong tin san phawm tren shop nha
	// và kiểm tra xem cái sản phẩm có tăng hay ko và sử lí chô tăng luôn
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/shop/user/disCart")
	public String disCartShop(@RequestBody CartItem test) {
		
		System.out.println("Cái số lượng sau khi tăng lên: " + test.getQuantity());
		// bắt try lỗi khi click sản phẩm đầu tiên
		try {
			
			int cartSize = 0;
			
			if(session.getAttribute("cartSize") != null) {
				 cartSize = (int) session.getAttribute("cartSize");
			}
			
			int id = test.getId();
			
			Products product = this.productRepo.findByProductId(id);

			String name = product.getTitles();

			int quantity = 1;
			
			
			float giamGia =0; 
			try {
				giamGia=product.getPrice()*product.getDiscounts().getPrice_discounts() / 100;	
			} catch (Exception e) {
				giamGia = 0;
			}
												
			float price = product.getPrice() - giamGia;
			String images = product.getImages();
			float orderMoney = 0;
			
			  orderMoney =  price* 1;
			  System.out.println("số tiền sản phẩm khi click vào shop: orderMoney->> " + orderMoney);				 
			CartItem item = new CartItem(id, name, quantity, price, images, orderMoney);
			Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
			if (cart == null) {
				cart = new HashMap<Integer, CartItem>();
			}

			if (cart.containsKey(id)) {
				CartItem existingItem = cart.get(id);
				existingItem.setQuantity(existingItem.getQuantity() - 1);
				existingItem.setOrderMoney((product.getPrice()-giamGia) * existingItem.getQuantity());
				
			} else {
				
				cart.put(id, item);
				cartSize++;
			}
			
			float total = 0;
			for (Entry<Integer, CartItem> entry : cart.entrySet()) {
				total += entry.getValue().getQuantity() * entry.getValue().getPrice();
			}
			
			session.setAttribute("cartSize", cartSize);
			session.setAttribute("cart", cart);
			session.setAttribute("total", total);				
		} catch (Exception e) {
			System.out.println("Lỗi truy vấn sản phẩm");
		}
		return "/user/cart";
	}
}
