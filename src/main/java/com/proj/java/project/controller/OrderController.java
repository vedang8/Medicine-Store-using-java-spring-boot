package com.proj.java.project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.java.project.entity.Medicine;
import com.proj.java.project.entity.Order;
import com.proj.java.project.entity.User;
import com.proj.java.project.repository.CategoryDao;
import com.proj.java.project.repository.MedicineDao;
import com.proj.java.project.repository.OrderDao;
import com.proj.java.project.service.UserService;

@Controller
public class OrderController {
   
	@Autowired
	private UserService us;
	
	@Autowired
	private MedicineDao md;
//	
	@Autowired
	private OrderDao od;
//	
	@Autowired
    private CategoryDao cd;

//	
	@GetMapping("/order/{id1}/{id2}")
//    @ResponseBody
	public String orderconfirm(@PathVariable("id1") int mid ,@PathVariable("id2") int uid,ModelMap ordermodel) {
		ordermodel.addAttribute("mid", mid);
		ordermodel.addAttribute("uid", uid);
		ordermodel.addAttribute("name",us.getUser(uid).getName());
		ordermodel.addAttribute("mobileno", us.getUser(uid).getMobileno());
		ordermodel.addAttribute("address",us.getUser(uid).getAddress());
		ordermodel.addAttribute("medicine", md.getMedicine(mid));
		ordermodel.addAttribute("categories", cd.getcategories());
		return "order";
	}
	
	
//	add to  cart
	@GetMapping("/add/cart/{id1}/{id2}")
	public String addtocart(@PathVariable("id1") int mid ,@PathVariable("id2") int uid,ModelMap m){
		m.addAttribute("medicines", md.getMedicines());
//      
		Order o = new Order();
		o.setCustomerName(us.getUser(uid).getName());
		o.setMobileno( us.getUser(uid).getMobileno());
		o.setAddress(us.getUser(uid).getAddress());
		o.setCname(md.getMedicine(mid).getCname());
		o.setMname(md.getMedicine(mid).getMname());
		o.setPrice(md.getMedicine(mid).getPrice());
		o.setOdate(new Date());
		  User u=us.getUser(uid);
		System.out.println(o);
//		od.addOrder(o);
		List<Order> ol;
		if(us.getUser(uid).getOrderlist() != null) {
		 ol= us.getUser(uid).getOrderlist();
		}
		else {
		ol = new ArrayList<>();
		}
		ol.add(o);

	  System.out.println(u);
	  u.setOrderlist(ol); 
		us.updateUser(u);
		m.addAttribute("id", uid);
		m.addAttribute("categories", cd.getcategories());
		return "buy";
	}
	
	
	@GetMapping("/checkout/{id}")
	public String checkout(@PathVariable("id") int id,ModelMap m){
		m.addAttribute("medicines", us.getUser(id).getOrderlist());
		m.addAttribute("id", id);
		m.addAttribute("categories", cd.getcategories());
		return "checkout";
	}
	

// final order placed
	@GetMapping("/placeorder/{id}")
	public String placeorder(@PathVariable("id") int id,ModelMap m){
	 User u =	us.getUser(id);
	 u.setOrderlist(null);
		us.updateUser(u);
		m.addAttribute("emty", "your order is placed successfully");
		m.addAttribute	("medicines", us.getUser(id).getOrderlist());
		m.addAttribute("categories", cd.getcategories());
		return "checkout";
	}
	
	@GetMapping("/remove/{id1}/{id2}")
	public String removefromcart(@PathVariable("id1") int oid,@PathVariable("id2") int uid,ModelMap m){
	 User u =	us.getUser(uid);
	 List<Order> l = u.getOrderlist();
	 Order o = od.getOrder(oid);
	 l.remove(o);
	 u.setOrderlist(l);
		us.updateUser(u);
		m.addAttribute("emty", "");
		m.addAttribute("medicines", us.getUser(uid).getOrderlist());
		m.addAttribute("categories", cd.getcategories());
		return "checkout";
	}
	
	@GetMapping("/back/buypage/{id}")
//	@ResponseBody
	public String backpage(@PathVariable("id") int uid,ModelMap m) {
		m.addAttribute("medicines", md.getMedicines());
		m.addAttribute("id", uid);
		m.addAttribute("categories", cd.getcategories());
		return "buy";
	}
	
	@PostMapping("/search/medicine/{id}")
//	@ResponseBody
	public String search(@PathVariable("id") int uid,@RequestParam("categoryname") String name,ModelMap m) {
		List<Medicine> t = md.getMedicines();
		List<Medicine> temp = new ArrayList<Medicine>();
		for(Medicine i : t) {
			if(name.equals(i.getCategoryname())) {
				temp.add(i);
			}
		}
		m.addAttribute("medicines", temp);
		m.addAttribute("categories", cd.getcategories());
		
		m.addAttribute("id", uid);
		return "buy";
	}
	
}
