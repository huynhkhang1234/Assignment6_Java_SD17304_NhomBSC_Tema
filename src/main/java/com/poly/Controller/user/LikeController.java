package com.poly.Controller.user;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poly.DAO.LikesDAO;
import com.poly.DAO.ProductsDAO;
import com.poly.Entities.Likes;
import com.poly.Entities.Products;
import com.poly.Entities.Users;
import com.poly.utils.XDate;

@Controller
public class LikeController {
	@Autowired
	HttpSession session;
	@Autowired
	ProductsDAO productRepo;
	@Autowired
	LikesDAO likeRepo;

	@PostMapping("/user/product/like")
	public String like(@RequestBody Products id) {

		Likes like = new Likes();
		Users user = (Users) session.getAttribute("userLogin");
		Products product = this.productRepo.findByProductId(id.getId());
		System.out.println(id.getId());
		System.out.println(user.getId());
		try {
			Likes likeId = this.likeRepo.findbyProductLike(id.getId(), user.getId());
			if (likeId != null) {
				if (likeId.getIs_likes() == 1) {
					likeId.setIs_likes(0);
					likeRepo.save(likeId);
				} else {
					likeId.setIs_likes(1);
					likeRepo.save(likeId);
				}
			}else {
				System.out.println("dữ liệu tìm kiếm không có");
				like.setUsers(user);
				like.setProducts(product);
				like.setCreate_like(XDate.now());
				like.setIs_likes(1);
				likeRepo.save(like);
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return "/user/shop";
	}

}
