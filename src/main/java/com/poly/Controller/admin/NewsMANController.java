/*
 * package com.poly.Controller.admin;
 * 
 * import java.io.BufferedOutputStream; import java.io.File; import
 * java.io.FileOutputStream; import java.util.Date; import java.util.List;
 * 
 * import javax.servlet.ServletContext; import javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.poly.DAO.Categories_newsDAO; import com.poly.DAO.NewsDAO; import
 * com.poly.DAO.UsersDAO; import com.poly.Entities.Categories_news; import
 * com.poly.Entities.News; import com.poly.Entities.Users;
 * 
 * @Controller public class NewsMANController {
 * 
 * @Autowired NewsDAO dao;
 * 
 * @Autowired Categories_newsDAO cateNewsDao;
 * 
 * @Autowired UsersDAO userDao;
 * 
 * @Autowired HttpSession session;
 * 
 * @Autowired ServletContext app;
 * 
 * private String nameImage = "";
 * 
 * @GetMapping("admin/news") public String index(Model model) { News entity =
 * new News(); model.addAttribute("news", entity);
 * 
 * Date now = new Date();
 * 
 * model.addAttribute("now", now);
 * 
 * List<News> list = dao.findAllActiveTrue();
 * 
 * List<Categories_news> listLoai = cateNewsDao.findAll();
 * 
 * model.addAttribute("list", list); model.addAttribute("listLoai", listLoai);
 * 
 * return "admin/news"; }
 * 
 * @PostMapping("/admin/news/update/{id}") public String update(Model
 * model, @ModelAttribute("news") News entity, @RequestParam("username") String
 * username,
 * 
 * @RequestParam("image") MultipartFile file) {
 * 
 * Users u = userDao.findByUsername(username); entity.setUsers(u);
 * 
 * Date now = new Date();
 * 
 * if (entity.getCreate_date() == null) entity.setCreate_date(now);
 * 
 * entity.setUpdate_date(now); entity.setIs_active(1);
 * 
 * String uploadRootPath = app.getRealPath("images/news-img/"); File
 * uploadRootDir = new File(uploadRootPath); if (!uploadRootDir.exists()) {
 * uploadRootDir.mkdirs(); } try { String fileName = file.getOriginalFilename();
 * File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator +
 * fileName); BufferedOutputStream stream = new BufferedOutputStream(new
 * FileOutputStream(serverFile)); stream.write(file.getBytes()); stream.close();
 * entity.setImages(fileName);
 * 
 * } catch (Exception e) { model.addAttribute("message", "Loi upload file");
 * 
 * }
 * 
 * dao.saveAndFlush(entity);
 * 
 * return "redirect:/admin/news"; }
 * 
 * @PostMapping("admin/news/save") public String save(Model
 * model, @ModelAttribute("news") News entity,
 * 
 * @RequestParam("image") MultipartFile file) {
 * 
 * Users u = (Users) session.getAttribute("userLogin"); entity.setUsers(u);
 * 
 * Date now = new Date(); if (entity.getCreate_date() == null)
 * entity.setCreate_date(now);
 * System.out.println(entity.getContents().length());
 * entity.setUpdate_date(now); entity.setIs_active(1);
 * 
 * String uploadRootPath = app.getRealPath("images/news-img/"); File
 * uploadRootDir = new File(uploadRootPath); if (!uploadRootDir.exists()) {
 * uploadRootDir.mkdirs(); } try { String fileName = file.getOriginalFilename();
 * File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator +
 * fileName); BufferedOutputStream stream = new BufferedOutputStream(new
 * FileOutputStream(serverFile)); stream.write(file.getBytes()); stream.close();
 * entity.setImages(fileName);
 * 
 * } catch (Exception e) { model.addAttribute("message", "Loi upload file");
 * 
 * }
 * 
 * dao.save(entity); return "redirect:/admin/news";
 * 
 * }
 * 
 * //xử lí nút edit và đổ dữ liệu bên table
 * 
 * @GetMapping("/admin/news/edit/{id}") public String edit(Model
 * model, @ModelAttribute("news") News entity, @PathVariable("id") Integer id) {
 * 
 * entity = dao.getById(id); model.addAttribute("news", entity);
 * 
 * List<Categories_news> listLoai = cateNewsDao.findAll();
 * model.addAttribute("listLoai", listLoai);
 * 
 * List<News> list = dao.findAllActiveTrue(); model.addAttribute("list", list);
 * return "admin/news"; }
 * 
 * @GetMapping("/admin/news/delete/{id}") public String
 * delete(@ModelAttribute("news") News entity, @PathVariable("id") Integer id) {
 * 
 * entity = dao.getOne(id); entity.setIs_active(0);
 * 
 * dao.saveAndFlush(entity); return "redirect:/admin/news"; }
 * 
 * @GetMapping("/admin/reset") public String reset() {
 * 
 * return "redirect:/admin/news"; } }
 */