package com.proj.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.java.project.entity.Category;
import com.proj.java.project.entity.Medicine;
import com.proj.java.project.repository.CategoryDao;
//import com.proj.java.project.repository.CategotyDao;
import com.proj.java.project.repository.MedicineDao;
import com.proj.java.project.service.AdminService;
import com.proj.java.project.service.CategoryService;
import com.proj.java.project.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class AdminController {
      
	 @Autowired
	  private MedicineDao md;
	 
	 @Autowired
	  private CategoryDao cd;
	
	 @Autowired
	  private AdminService as;
	  
	 @Autowired
	  private UserService us;
	  
	 @Autowired
	  private CategoryService cs;
	  
	 @GetMapping("login")
	    public String adminLogin() {
	    	return "login_page";
	  }
	 
	    @PostMapping("login")
	    public String checkStudent(@RequestParam(value = "username", required = true) String email,
	                               @RequestParam(value = "password", required = true) String password,HttpServletRequest request, ModelMap model){
	        if(as.login(email,password)){
	        	HttpSession session = request.getSession();
	        	session.setAttribute("role", "student");
	        	model.addAttribute("success", "Login Successfully");
	        	List<Medicine> l = md.getMedicines();
	        	List<Category> cl = cd.getcategories();
	        	model.addAttribute("categories",cl);
	            model.addAttribute("medicines",l);
	        }
	        else{
	        	model.addAttribute("error", "Wrong credentials !!");
	        	return "login_page";
	        }
	        return "/medicines";
	    }
	    
	    @RequestMapping("logout")
	    public String logout(HttpServletRequest request,Model logout) {
	    	HttpSession session = request.getSession();
	    	logout.addAttribute("lout","Successfully Logged out");
	    	session.invalidate();
	    	return "redirect:/";
	    }
   
	    @GetMapping("/remove/user")
//	    @ResponseBody
	    public String removeuser(ModelMap m){
	    	m.addAttribute("users",us.getUsers());
	    	m.addAttribute("categories", cd.getcategories());
	    	return "user_manage";
	    	
	    }
	    
	    @GetMapping("/remove/user/{id}")
//	    @ResponseBody
	    public String removeuserid(@PathVariable("id") int id, ModelMap m){
	    	us.deleteUser(id);
	        m.addAttribute("categories", cd.getcategories());
	    	m.addAttribute("emty", "user removed successfully");
	    	m.addAttribute("users",us.getUsers());
	    	return "user_manage";
	    }
	    
	    @GetMapping("/admin")
	    public String adminpage(Model m) {
	    	m.addAttribute("categories", cd.getcategories());
	    	m.addAttribute("medicines", md.getMedicines());
	    	return "medicines";
	    }
	    
	    
	    @GetMapping("/addCategory")
	    public String addcategory(Model m) {
	    	return "addcategory";
	    }
	    
	    
	    @Transactional
		@PostMapping("/add/category")
		public String addCategory(
	           @ModelAttribute("category")  Category c,
	            Model medicineModel) {
	           cd.addCate(c);
			medicineModel.addAttribute("msg", "category added successfully");
			List<Category> categories = cd.getcategories();
			medicineModel.addAttribute("categories", categories);
			return "categories";
		}
	    
	    
		@GetMapping("/delete/category/{id}")
		public String deleteMedicine(@PathVariable int id, ModelMap categoryModel) {
			cs.deletecategory(id);
			List<Category> categories = cd.getcategories();
			categoryModel.addAttribute("categories",categories );
			categoryModel.addAttribute("msg", "category deleted successfully");
			return "categories";
		}
	    
		@GetMapping("/categories")
		public String getMedicines(ModelMap categoryModel) {
			List<Category> medicines = cs.getcategories();
			categoryModel.addAttribute("categories", medicines);
			return "categories";
		}
		
		

		@GetMapping("update/category/{id}")
		public String updatecategory(@PathVariable("id") int id,ModelMap medicineModel) {
			medicineModel.addAttribute("id", id);
			medicineModel.addAttribute("categories", cd.getcategories());
			medicineModel.addAttribute("mdcn", cd.getCategory(id));
			System.out.println("hello");
			return "update_category";
		}
		
		@PostMapping("/update/category")
		public String updatecategory(@ModelAttribute("category") Category m,
				ModelMap categoryModel) {
			cd.updateCategory(m);
			categoryModel.addAttribute("categories", cd.getcategories());
			categoryModel.addAttribute("msg", "category updated successfully");
			return "redirect:/categories";
		}
}


