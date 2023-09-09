package com.poly.Controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.DAO.CategoriesDAO;
import com.poly.DAO.DiscountsDAO;
import com.poly.DAO.ProductsDAO;
import com.poly.DAO.SuppliersDAO;
import com.poly.Entities.Categories;
import com.poly.Entities.Discounts;
import com.poly.Entities.Products;
import com.poly.Entities.Suppliers;
import com.poly.service.B64Session;
import com.poly.utils.XDate;


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
	
	@Autowired
	B64Session b64s;

	@GetMapping("/admin/product")
	public String product(Model model, @ModelAttribute("product") Products ps, @RequestParam("p") Optional<Integer> p) {

		Products entity = new Products();

		entity.setCreate_date(new Date());
		entity.setUpdate_date(new Date());

		entity.setIs_status(1);

		model.addAttribute("product", entity);
		
		// Tìm User đã đăng nhập vào trang web
	    model.addAttribute("userLogin", b64s.getUserLogin());
		
		Pageable pageable;

		try {
			pageable = PageRequest.of(p.orElse(0), 9);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 9);
		}

		/* Sắp xếp giảm dần theo ngày */
		Sort sort = Sort.by(Sort.Direction.DESC, "create_date");

		Page<Products> listproduts = this.dao.getIsActive(pageable);
		model.addAttribute("list", listproduts);

		List<Suppliers> listSupp = suppdao.findAll();
		model.addAttribute("listSupp", listSupp);

		Date now = new Date();
		model.addAttribute("now", now);

		Discounts entityDis = new Discounts();

		String startDate = XDate.toString(new Date(), "yyyy-MM-dd");
		String endDate = XDate.toString(XDate.getDateAfter(1), "yyyy-MM-dd");

		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("discounts", entityDis);

		List<Discounts> listDis = disdao.findByAndIdNew();
		model.addAttribute("listDis", listDis);

		try {
			pageable = PageRequest.of(p.orElse(0), 8);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 8);
		}

		List<Categories> listCate = catedao.findByAndIdNew();
		model.addAttribute("listCate", listCate);

		Categories entityCate = new Categories();
		model.addAttribute("categories", entityCate);

		return "admin/product";
	}

	@PostMapping("/admin/save/product")
	public String saveProduct(Model model, @ModelAttribute("product") Products entity,
			@RequestParam("file") MultipartFile file, @RequestParam("createDay") String createDate,
			@RequestParam("updateDay") String updateDate) throws ParseException {

		if (entity.getCreate_date() == null)
			entity.setCreate_date(new Date());
		entity.setUpdate_date(new Date());

		/* entity.setIs_status(1); */
		entity.setIs_active(1);

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

		dao.save(entity);

		return "redirect:/admin/product";

	}

	@GetMapping("/admin/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id, @ModelAttribute("product") Products pro,
			@RequestParam("p") Optional<Integer> p, @RequestParam("cate") Categories cate,
			@RequestParam("supp") Suppliers supp, @RequestParam("dis") Discounts dis,
			@RequestParam("file") MultipartFile file, @RequestParam("createDay") String createDate,
			@RequestParam("updateDay") String updateDate) throws ParseException {

		model.addAttribute("id", id);

		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 8);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 8);
		}

		Page<Products> listproduts = this.dao.getIsActive(pageable);
		model.addAttribute("listproduts", listproduts);

		model.addAttribute("list", listproduts);

		pro = dao.getOne(id);

		String createDay = XDate.toString(pro.getCreate_date(), "yyyy-MM-dd");
		String updateDay = XDate.toString(pro.getUpdate_date(), "yyyy-MM-dd");

		model.addAttribute("createDay", createDay);
		model.addAttribute("updateDay", updateDay);

		model.addAttribute("discounts", dis);
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

	@PostMapping("/admin/save/discount")
	public String saveProduct(Model model, @ModelAttribute("discounts") Discounts entityDis,
			@RequestParam("startDay") String startDate, @RequestParam("endDay") String endDate) throws ParseException {

		entityDis.setStart_day(XDate.toDate(startDate));
		entityDis.setEnd_day(XDate.toDate(endDate));
		entityDis.setIs_active(1);

		disdao.saveAndFlush(entityDis);

		return "redirect:/admin/product";
	}

	@PostMapping("/admin/product/update/{id}")
	public String update(Model model, @ModelAttribute("products") Products entity, @PathVariable("id") Integer id,
			@RequestParam("cate") Categories cate, @RequestParam("supp") Suppliers supp,
			@RequestParam("dis") Discounts dis, @RequestParam("file") MultipartFile file,
			@RequestParam("createDay") String createDate, @RequestParam("updateDay") String updateDate)
			throws ParseException {

		entity.setCategories(cate);
		entity.setSuppliers(supp);
		entity.setDiscounts(dis);

		entity.setIs_active(1);

		if (entity.getCreate_date() == null)
			entity.setCreate_date(new Date());
		entity.setUpdate_date(new Date());

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

		dao.saveAndFlush(entity);

		return "redirect:/admin/product";
	}

	@GetMapping("/admin/product/delete/{id}")
	public String delete(@ModelAttribute("products") Products entity, @PathVariable("id") Integer id) {

		entity = dao.getOne(id);

		entity.setIs_active(0);

		dao.saveAndFlush(entity);

		return "redirect:/admin/product";
	}

	@PostMapping("/admin/discount/update/{id}")

	public String update(Model model, @ModelAttribute("discount") Discounts entityDis, @PathVariable("id") Integer id,
			@RequestParam("startDay") String startDate, @RequestParam("endDay") String endDate) throws ParseException {

		entityDis.setStart_day(XDate.toDate(startDate));
		entityDis.setEnd_day(XDate.toDate(endDate));

		// discounts
		disdao.saveAndFlush(entityDis);

		return "redirect:/admin/product";
	}

	@GetMapping("/admin/discount/delete/{id}")
	public String delete(Model model, @ModelAttribute("discounts") Discounts entityDis,
			@PathVariable("id") Integer id) {

		entityDis = disdao.getOne(id);

		entityDis.setIs_active(0);

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
	public String saveProduct(Model model, @Validated @ModelAttribute("category") Categories entityCate) {

		catedao.saveAndFlush(entityCate);

		return "redirect:/admin/product";
	}

	@GetMapping("/admin/category/delete/{id}")

	public String delete(@ModelAttribute("categories") Categories entityCate, @PathVariable("id") Integer id) {

		entityCate = catedao.getOne(id);

		entityCate.setIs_active(0);

		catedao.saveAndFlush(entityCate);

		return "redirect:/admin/product";

	}

	@GetMapping("/admin/discount/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id, @ModelAttribute("discounts") Discounts d,
			@RequestParam("p") Optional<Integer> p) {

		model.addAttribute("id", id);

		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 8);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 8);
		}
		Page<Products> listproduts = this.dao.getIsActive(pageable);
		model.addAttribute("listproduts", listproduts);

		model.addAttribute("list", listproduts);

		d = disdao.getOne(id);

		String startDate = XDate.toString(d.getStart_day(), "yyyy-MM-dd");
		String endDate = XDate.toString(d.getEnd_day(), "yyyy-MM-dd");

		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);

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

		cate = catedao.getOne(id);
		model.addAttribute("categories", cate);

		try {
			pageable = PageRequest.of(p.orElse(0), 8);
		} catch (Exception e) {
			pageable = PageRequest.of(0, 8);
		}

		Page<Categories> listCate = this.catedao.getIsActive(pageable);

		model.addAttribute("listCate", listCate);

		cate = catedao.getOne(id);
		model.addAttribute("categories", cate);

		Discounts d = new Discounts();
		model.addAttribute("discounts", d);

		List<Discounts> listDis = disdao.findAll();
		model.addAttribute("listDis", listDis);

		return "/admin/product";
	}

	/* Export file sản phẩm */
	@GetMapping("/export")
	public void exportProductsToExcel(HttpServletResponse response) throws IOException {
		List<Products> productList = dao.findAll();

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Products");

		// Tạo dòng header
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("id");
		headerRow.createCell(1).setCellValue("titles");
		headerRow.createCell(2).setCellValue("price");
		headerRow.createCell(3).setCellValue("images");
		headerRow.createCell(4).setCellValue("create_date");
		headerRow.createCell(5).setCellValue("update_date");
		headerRow.createCell(6).setCellValue("is_status");
		headerRow.createCell(7).setCellValue("original_price");
		headerRow.createCell(8).setCellValue("description");

		// Đổ dữ liệu sản phẩm vào sheet
		int rowIndex = 1;
		for (Products pro : productList) {
			Row row = sheet.createRow(rowIndex);
			row.createCell(0).setCellValue(pro.getId());
			row.createCell(1).setCellValue(pro.getTitles());
			row.createCell(2).setCellValue(pro.getPrice());
			row.createCell(3).setCellValue(pro.getImages());
			row.createCell(4).setCellValue(pro.getCreate_date());
			row.createCell(5).setCellValue(pro.getUpdate_date());
			row.createCell(6).setCellValue(pro.getIs_status());
			row.createCell(7).setCellValue(pro.getOriginal_price());
			row.createCell(8).setCellValue(pro.getDescription());

			rowIndex++;
		}

		// Thiết lập kiểu và tiêu đề file Excel
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=products.xlsx");

		// Ghi workbook vào luồng đầu ra của response
		workbook.write(response.getOutputStream());

		// Đóng workbook
		workbook.close();
	}

	// Import sản phẩm từ file Excel
	
	@PostMapping("/import")
    public ResponseEntity<String> importProducts(@RequestParam("file") MultipartFile file,
            @RequestParam("folder") String folderPath) throws IOException {
		
        // Kiểm tra xem thư mục đã tồn tại chưa
        File folder = new File(folderPath);
        
        if (!folder.exists()) {
            // Tạo thư mục nếu chưa tồn tại
            boolean created = folder.mkdirs();
            
            if (!created) {
                // Xử lý lỗi tạo thư mục
                return ResponseEntity.badRequest().body("Không thể tạo thư mục");
            }
        }

        // Lưu file Excel vào thư mục
        File excelFile = new File(folderPath, file.getOriginalFilename());
        
        try (FileOutputStream fos = new FileOutputStream(excelFile)) {
        	
            FileCopyUtils.copy(file.getInputStream(), fos);
            
        } catch (IOException e) {
        	
            // Xử lý lỗi lưu file
            return ResponseEntity.badRequest().body("Không thể lưu file");
        }

        // Đọc file Excel và thực hiện import
        try (Workbook workbook = WorkbookFactory.create(excelFile)) {
        	
            // Thực hiện xử lý dữ liệu từ file Excel //
        	Sheet sheet = workbook.getSheetAt(0);
        	for (Row row : sheet) {
        		  
        		  String titles = row.getCell(0).getStringCellValue();
        		  
        		  System.out.println(titles);
        	}
        } catch (IOException e) {
        	
            // Xử lý lỗi đọc file Excel
            return ResponseEntity.badRequest().body("Không thể đọc file Excel");
        }

        // Trả về thông báo thành công
        return ResponseEntity.ok("Import sản phẩm thành công");
    }

}