package com.proj.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.java.project.entity.Medicine;
import com.proj.java.project.entity.User;
import com.proj.java.project.repository.CategoryDao;
import com.proj.java.project.repository.MedicineDao;
import com.proj.java.project.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	
 @Autowired
	private UserService us;
	
 
 @Autowired
 private MedicineDao md;
 
 @Autowired
 private CategoryDao cd;
 
 
	@PostMapping("/add/user")
	 public String registerUser(@ModelAttribute("user") User u, ModelMap model) {
	    	us.addUser(u);
	    	model.addAttribute("success","Account Created Successfully");
	    	model.addAttribute("categories", cd.getcategories());
	    	return "user_login";
	    }
	
	@GetMapping("/user/login/a")
	public String login() {
		
		return "user_login";
	}
	
	@PostMapping("/user/login")
//	@ResponseBody
	public String checkUser(@RequestParam(value = "username", required = true) String email,
     @RequestParam(value = "password", required = true) String password,HttpServletRequest request, ModelMap model){
			User user = us.login(email,password);
			  if(user == null){
			   model.addAttribute("error", "Wrong credentials !!");
			   return "user_login";
			}	
		HttpSession session = request.getSession();
		session.setAttribute("role", "user");
		model.addAttribute("medicines", md.getMedicines());
		model.addAttribute("categories", cd.getcategories());
		session.setAttribute("id",user.getId());
		model.addAttribute("success", "Logged in Successfully");
		model.addAttribute("categories", cd.getcategories());
		return "buy";
}
	
	
	@GetMapping("update/editprofile/{id}")
	public String updateProfile(@PathVariable("id") int id,ModelMap userModel) {
		userModel.addAttribute("id", id);
		userModel.addAttribute("user", us.getUser(id));
		userModel.addAttribute("categories", cd.getcategories());
//		System.out.println("hello");
		return "edit_profile";
	}
	
	
	@PostMapping("/update/user")
	public String update(@ModelAttribute("user") User u,
			ModelMap userModel) {
		us.updateUser(u);
		userModel.addAttribute("medicines",md.getMedicines());
		userModel.addAttribute("update", "your details are updated successfully");
		userModel.addAttribute("categories", cd.getcategories());
		return "buy";
	}
	
	
	
	
	
}
