package com.poly.Controller.admin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DAO.Order_detailsDAO;
import com.poly.DAO.OrdersDAO;
import com.poly.Entities.Order_details;
import com.poly.Entities.Orders;
import com.poly.utils.XDate;

@Controller
@RequestMapping("/admin")
public class HomepageMANController {
	
	@Autowired
	OrdersDAO oDAO;
	
	@Autowired
	Order_detailsDAO odDAO;
	
	@GetMapping("/index")
	public String view(Model m) {
		double doanhThu = 0;
		int soLuong = 0;
		double chiPhi = 0;
		double chiPhiKhac = 0;
		double von = 0;
		
		List<Orders> listO = (List<Orders>) m.asMap().get("listO");

	    if (listO == null) {
	        listO = oDAO.findAll();
	    }
	    
	    
	    for (Orders o : listO) {
			for (Order_details od : o.getOrder_details()) {
				if(od.getProducts().getDiscounts() == null)
					von += od.getProducts().getOriginal_price() * od.getQuanlity();
				else 
					von += od.getProducts().getOriginal_price()*((100 - od.getProducts().getDiscounts().getPrice_discounts()) / 100) * od.getQuanlity();
				soLuong += od.getQuanlity();
			}
			doanhThu += o.getMoney_received() - von;
		}

	    String startDate = XDate.toString(new Date(), "yyyy-MM-dd");
	    String endDate = XDate.toString(XDate.getDateAfter(10), "yyyy-MM-dd");

	    m.addAttribute("listO", listO);
	    m.addAttribute("startDate", startDate);
	    m.addAttribute("endDate", endDate);
	    m.addAttribute("doanhThu", doanhThu);
	    m.addAttribute("soLuong", soLuong);

	    return "admin/index";
	}
	
	@PostMapping("/index/thongke")
	public String submit(
			@RequestParam("startDate") String startDateTemp,
			@RequestParam("endDate") String endDateTemp,
			Model m) {
		try {
			
			LocalDate date1 = LocalDate.parse(startDateTemp);
			LocalDate date2 = LocalDate.parse(endDateTemp);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			String a = date1.format(formatter);
			String b = date2.format(formatter);

			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date startDate = format.parse(a);
			Date endDate = format.parse(b);

			java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
			java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

			List<Orders> listO = null;
			 //phương thức before sẽ kiểm tra ngày của tham số truyền vào có lớn hơn ngày bắt đầu hay không
			if (endDate.before(startDate)) {
				m.addAttribute("message", "Ngày kết thúc phải lớn ngày bắt đầu nhe bé!!!");
				listO = null;
			} else {
				listO = oDAO.findByCreateDateBetween(sqlStartDate, sqlEndDate);
				if (listO.size() <= 0) 
					listO = null;
			}
			
			 String startDate1 = XDate.toString(startDate, "yyyy-MM-dd");
		     String endDate1 = XDate.toString(endDate, "yyyy-MM-dd");

		     m.addAttribute("startDate", startDate1);
		     m.addAttribute("endDate", endDate1);
	         m.addAttribute("listO", listO);
		     
		     return "admin/index";
	    } catch (Exception e) {
	        e.printStackTrace();
	         //Xử lý trường hợp lỗi và chuyển hướng đến "/admin/index" với thông báo lỗi
	        return "redirect:/admin/index?error=1";
	    }
	}
}
