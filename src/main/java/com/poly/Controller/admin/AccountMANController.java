package com.poly.Controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.Beans.AccountAdmin;
import com.poly.DAO.RolesDAO;
import com.poly.DAO.UsersDAO;
import com.poly.Entities.Roles;
import com.poly.Entities.Users;
import com.poly.utils.XDate;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AccountMANController {
	@Autowired
	UsersDAO userDao;
	@Autowired
	RolesDAO rolesDao;

	@Autowired
	ServletContext app;
	// ko thể khóa tài khoản hiện tại.
	@Autowired
	HttpSession session;

	@GetMapping("admin/account")
	public String index(Model model,@RequestParam("p") Optional<Integer> p) {
		 Users entity = new Users();
		 model.addAttribute("users", entity);
		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 5);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 5);
			e.printStackTrace();
		}						
		Page<Users> listproduts =  this.userDao.getIsActive(pageable);
		model.addAttribute("list", listproduts);
		return "admin/account";
	}

	@PostMapping("/account/create")
	public String Create(Model model, @Valid @ModelAttribute("users") AccountAdmin entity, BindingResult result,
			@RequestParam("file") MultipartFile file) {

		if (result.hasErrors()) {

			System.out.println("có lỗi.");
			System.out.println(entity);
			return "/admin/account";
		} else {

			System.out.println("không lỗi nủa");
			Users uss = this.userDao.findByEmail(entity.getEmail().trim());
			if (uss == null) {
				if (entity.getCreate_date() == null)
					entity.setCreate_date(new Date());
				entity.setUpdate_date(new Date());

				/* Xử lý hình ảnh */
				String uploadRootPath = app.getRealPath("images/user-img/");
				File uploadRootDir = new File(uploadRootPath);
				if (!uploadRootDir.exists()) {
					uploadRootDir.mkdirs();
				}
				try {
					String fileName = file.getOriginalFilename();
					File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + fileName);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(file.getBytes());
					stream.close();
					entity.setImages(fileName);
				} catch (Exception e) {
					model.addAttribute("message", "Lỗi upload file!");
				}

				Users us = new Users();
				us.setUser_names(entity.getUser_names());
				us.setFirst_names(entity.getFirst_names());
				us.setLast_names(entity.getLast_names());
				us.setCreate_date(XDate.now());
				us.setEmail(entity.getEmail());
				us.setIs_active(1);
				us.setAddress(entity.getAddress());
				us.setPass_words(entity.getPass_words());
				us.setPhones(entity.getPhones());
				us.setImages(entity.getImages());
				Roles roles = new Roles();
				if (entity.getRoles().getId() == 1) {
					roles.setId(1);
					roles.setRoles("admin");
					roles.setActions("admin");
					us.setRoles(roles);
				}
				if (entity.getRoles().getId() == 2) {
					roles.setId(2);
					roles.setRoles("user");
					roles.setActions("views");
					us.setRoles(roles);
				}
				if (entity.getRoles().getId() == 3) {
					roles.setId(2);
					roles.setRoles("user");
					roles.setActions("views");
					us.setRoles(roles);
				}

				this.userDao.save(us);
			}else {
				System.out.println("Email đã tồn tại");
				model.addAttribute("error", "Email đã tồn tại trong hệ thông");
				return "redirect:/admin/account";
			}
		}

		return "redirect:/admin/account";

	}

	@PostMapping("/account/update/{id}")
	public String update(Model model, @ModelAttribute("users") Users entity, @PathVariable("id") Integer id,
			@RequestParam("file") MultipartFile file) {

		if (entity.getCreate_date() == null)
			entity.setCreate_date(new Date());
		entity.setUpdate_date(new Date());

		entity.setIs_active(1);

		/* Xử lý hình ảnh */
		String uploadRootPath = app.getRealPath("images/user-img/");
		File uploadRootDir = new File(uploadRootPath);
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		try {
			String fileName = file.getOriginalFilename();
			File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(file.getBytes());
			stream.close();
			entity.setImages(fileName);
		} catch (Exception e) {
			model.addAttribute("message", "Lỗi upload file!");
		}

		userDao.saveAndFlush(entity);
		return "redirect:/admin/account";

	}

	@GetMapping("/account/edit/{id}")
	public String edit(Model model, @ModelAttribute("users") Users entity, @PathVariable("id") Integer id,
			@RequestParam("p") Optional<Integer> p
			) {
		///		
		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 5);
			
		} catch (Exception e) {
			pageable = PageRequest.of(0, 5);
			e.printStackTrace();
		}				
		Page<Users> listproduts =  this.userDao.getIsActive(pageable);		
		entity = userDao.getOne(id);
		model.addAttribute("users", entity);
		// tìm kiếm để ia ra dữ liệu toàn bộ
		model.addAttribute("list", listproduts);
		return "admin/account";
	}

	@GetMapping("/account/delete/{id}")
	public String view(@ModelAttribute("users") Users entity, @PathVariable("id") Integer id) {

		entity = userDao.getOne(id);
		entity.setIs_active(0);

		userDao.saveAndFlush(entity);
		return "redirect:/admin/account";
	}

	@GetMapping("/account/close/{id}")
	public String Close(@ModelAttribute("users") Users entity, @PathVariable("id") Integer id) {
		System.out.println(id + "id");
		
		entity = userDao.getOne(id);
		Users us = (Users) session.getAttribute("userLogin");
		if (!us.getEmail().equals(entity.getEmail())) {
			if (entity.getIs_active() == 1) {

				entity.setIs_active(3);
			} else {

				entity.setIs_active(1);
			}
			userDao.saveAndFlush(entity);
		} else {
			// bị trùng thông báo lên.
		}

		return "redirect:/admin/account";
	}

}
