package com.poly.Controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poly.DAO.CategoriesDAO;
import com.poly.DAO.DiscountsDAO;
import com.poly.DAO.ProductsDAO;
import com.poly.DAO.SuppliersDAO;
import com.poly.Entities.Categories;
import com.poly.Entities.Discounts;
import com.poly.Entities.Products;
import com.poly.Entities.Suppliers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductMANController {

	@Autowired
	ProductsDAO dao;

	@Autowired
	DiscountsDAO disdao;

	@Autowired
	CategoriesDAO catedao;

	@Autowired
	SuppliersDAO suppdao;

	@Autowired
	ServletContext app;

	@Autowired
	HttpSession session;

	@GetMapping("/admin/product")
	public String product(Model model, @ModelAttribute("product") Products ps, @RequestParam("p") Optional<Integer> p) {

		// products
		Products entity = new Products();
		model.addAttribute("products", entity);
		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 9);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 9);
		}
		Page<Products> listproduts = this.dao.getIsActive(pageable);
		model.addAttribute("list", listproduts);
		//
		List<Suppliers> listSupp = suppdao.findAll();
		model.addAttribute("listSupp", listSupp);

		Date now = new Date();
		model.addAttribute("now", now);

		// discounts
		Discounts entityDis = new Discounts();
		model.addAttribute("discounts", entityDis);
		List<Discounts> listDis = disdao.findAll();
		model.addAttribute("listDis", listDis);

		// categories
		try {
			pageable = PageRequest.of(p.orElse(0), 8);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 8);
		}
		Page<Categories> listCate = this.catedao.getIsActive(pageable);
		model.addAttribute("listCate", listCate);

		Categories entityCate = new Categories();
		model.addAttribute("categories", entityCate);
		
		/*
		 * List<Categories> listCate = catedao.findAll(); model.addAttribute("listCate",
		 * listCate);
		 */
		 

		return "admin/product";
	}

	@PostMapping("/admin/save/product")
	public String saveProduct(Model model, @ModelAttribute("product") Products entity,
			@RequestParam("cate") Categories cate, @RequestParam("supp") Suppliers supp,
			@RequestParam("dis") Discounts dis, @RequestParam("file") MultipartFile file) {
		Date now = new Date();

		entity.setCategories(cate);
		entity.setSuppliers(supp);
		entity.setDiscounts(dis);

		if (entity.getCreate_date() == null)
			entity.setCreate_date(now);
		entity.setUpdate_date(now);

		// Xử lý hình ảnh String

		String uploadRootPath = app.getRealPath("images/product-img/");
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

		// products

		dao.saveAndFlush(entity);

		return "redirect:/admin/product";
	}

	@PostMapping("/admin/save/discount")
	public String saveProduct(Model model, @ModelAttribute("discount") Discounts entityDis,
			@RequestParam("dis") Discounts dis) {

		Date now = new Date();
		System.out.println(entityDis);

		if (entityDis.getStart_day() == null)
			entityDis.setStart_day(now);
		entityDis.setEnd_day(now);

		// discounts
		disdao.saveAndFlush(entityDis);

		return "redirect:/admin/product";
	}

	@PostMapping("/admin/product/update/{id}")
	public String update(Model model, @ModelAttribute("products") Products entity, @PathVariable("id") Integer id,
			@RequestParam("cate") Categories cate, @RequestParam("supp") Suppliers supp,
			@RequestParam("dis") Discounts dis, @RequestParam("file") MultipartFile file) {

		Date now = new Date();

		entity.setCategories(cate);
		entity.setSuppliers(supp);
		entity.setDiscounts(dis);
		entity.setIs_active(1);
		if (entity.getCreate_date() == null)
			entity.setCreate_date(now);
		entity.setUpdate_date(now);

		if (file.getOriginalFilename() == null || file.getOriginalFilename().length() == 0) {
			Products p = dao.getById(entity.getId());

			if (!(p.getImages() == null || p.getImages().length() == 0)) {
				entity.setImages(p.getImages());
			}
		}

		String uploadRootPath = app.getRealPath("images/product-img/");
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
			model.addAttribute("message", "Lỗi upload file");

		}

		// products
		dao.saveAndFlush(entity);

		return "redirect:/admin/product";
	}

	@GetMapping("/admin/product/delete/{id}")
	public String delete(@ModelAttribute("products") Products entity, @PathVariable("id") Integer id) {

		// products
		entity = dao.getOne(id);
		entity.setIs_active(0);

		dao.saveAndFlush(entity);

		return "redirect:/admin/product";
	}

	@PostMapping("/admin/discount/update/{id}")
	public String update(Model model, @ModelAttribute("discounts") Discounts entityDis, @PathVariable("id") Integer id,
			@RequestParam("dis") Discounts dis) {

		Date now = new Date();
		if (entityDis.getStart_day() == null)
			entityDis.setStart_day(now);
			entityDis.setEnd_day(now);

		// discounts
		disdao.saveAndFlush(entityDis);

		return "redirect:/admin/product";
	}

	@PostMapping("/admin/category/update/{id}")
	public String update(Model model, @ModelAttribute("categories") Categories entityCate,
			@PathVariable("id") Integer id) {

		// categories
		entityCate.setIs_active(1);
		catedao.saveAndFlush(entityCate);

		return "redirect:/admin/product";
	}

	@PostMapping("/admin/save/category")
	public String saveProduct(Model model, @ModelAttribute("category") Categories entityCate) {

		// categories

		catedao.saveAndFlush(entityCate);

		return "redirect:/admin/product";
	}

	@GetMapping("/admin/category/delete/{id}")
	public String delte(Model model, @ModelAttribute("categories") Categories entityCate,
			@PathVariable("id") Integer id) {

		entityCate = catedao.getOne(id);
		entityCate.setIs_active(0);
		catedao.saveAndFlush(entityCate);
		return "redirect:/admin/product";
	}

	@GetMapping("/admin/discount/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id, @ModelAttribute("discounts") Discounts d,
			@RequestParam("p") Optional<Integer> p) {

		// products
		// products
		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 8);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 8);
		}
		Page<Products> listproduts = this.dao.getIsActive(pageable);
		model.addAttribute("listproduts", listproduts);

		//
		// Products entity = new Products();
		// model.addAttribute("products", entity);
		// List<Products> list = dao.findAllActiveTrue(Sort.by(Direction.DESC,
		// "is_status"));
		model.addAttribute("list", listproduts);

		// discounts

		d = disdao.getById(id);
		model.addAttribute("discounts", d);
		List<Discounts> listDis = disdao.findAll();
		model.addAttribute("listDis", listDis);
		
		Products entity = new Products();
		model.addAttribute("products", entity);
		Categories ct = new Categories();
		model.addAttribute("categories", ct);
		
		try {
			pageable = PageRequest.of(p.orElse(0), 8);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 8);
		}
		Page<Categories> listCate = this.catedao.getIsActive(pageable);
		model.addAttribute("listCate", listCate);

		return "/admin/product";
	}

	@GetMapping("/admin/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id, @ModelAttribute("categories") Categories cate,
			@RequestParam("p") Optional<Integer> p) {

		// products
		Products entity = new Products();
		model.addAttribute("products", entity);
		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 9);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 9);
		}
		Page<Products> listproduts = this.dao.getIsActive(pageable);
		model.addAttribute("list", listproduts);
		// categories
		cate = catedao.getById(id);
		model.addAttribute("categories", cate);
		/*
		 * session.setAttribute("idCate", cate.getId());
		 * session.setAttribute("nameCate", cate.getNames());
		 */
		try {
			pageable = PageRequest.of(p.orElse(0), 8);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 8);
		}
		Page<Categories> listCate = this.catedao.getIsActive(pageable);
		model.addAttribute("listCate", listCate);

		cate = catedao.getById(id);
		model.addAttribute("categories", cate);
		
		Discounts d = new Discounts();
		model.addAttribute("discounts", d);
		
		List<Discounts> listDis = disdao.findAll();
		model.addAttribute("listDis", listDis);

		return "/admin/product";
	}

}