package com.proj.java.project.controller;

import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.java.project.entity.Category;
import com.proj.java.project.entity.Medicine;
import com.proj.java.project.repository.CategoryDao;
import com.proj.java.project.repository.MedicineDao;
import com.sid.java.springbootmvchibernatedemo.entity.Teacher;

import jakarta.persistence.CascadeType;

import java.util.Date;
import java.util.List;

@Controller
public class MedicineController {

	@Autowired
	private MedicineDao md;
	
	@Autowired
	private CategoryDao cd;
    
	@GetMapping("/")
	public String gotohome(ModelMap MedicineModel) {
		return "home";
	}
	
	
	@GetMapping("/medicine/{id}")
	public String getMedicine(@PathVariable int id, ModelMap MedicineModel) {
		Medicine medicine = md.getMedicine(id);
		MedicineModel.addAttribute("medicine", medicine);
		List<Category> categories = cd.getcategories();
		MedicineModel.addAttribute("categories", categories);
		return "medicine";
	}

	@GetMapping("/medicines")
	public String getMedicines(ModelMap medicineModel) {
		List<Medicine> medicines = md.getMedicines();
		List<Category> categories = cd.getcategories();
		medicineModel.addAttribute("categories", categories);
		medicineModel.addAttribute("medicines", medicines);
		return "medicines";
	}

	@GetMapping("/addMedicine")
	public String addPage(ModelMap m) {
		List<Category> categories = cd.getcategories();
		m.addAttribute("categories", categories);
		return "add";
	}

	@PostMapping("/add/medicine")
	public String addMedicine(
           @ModelAttribute("medicine") Medicine m,
            Model medicineModel) {
           md.addMedicine(m);
		medicineModel.addAttribute("msg", "medicine added successfully");
		List<Medicine> medicines = md.getMedicines();
		medicineModel.addAttribute("categories", cd.getcategories());
		medicineModel.addAttribute("medicines", medicines);
		return "redirect:/medicines";
	}

	@GetMapping("update/medicine/{id}")
	public String updatePage(@PathVariable("id") int id,ModelMap medicineModel) {
		medicineModel.addAttribute("id", id);
		medicineModel.addAttribute("categories", cd.getcategories());
		medicineModel.addAttribute("mdcn", md.getMedicine(id));
		System.out.println("hello");
		return "update";
	}
	
	@PostMapping("/update/medicine")
	public String updateMedicine(@ModelAttribute("medicine") Medicine m,
			ModelMap medicineModel) {
		md.updateMedicine(m);
		medicineModel.addAttribute("categories", cd.getcategories());
		medicineModel.addAttribute("msg", "medicine updated successfully");
		return "redirect:/medicines";
	}

	@PostMapping("/update/medicineform")
	public String updateMedicine(
			@RequestParam int id,
            ModelMap medicineModel) {
		List<Medicine> candidates = md.getMedicines();
		medicineModel.addAttribute("candidates", candidates);
		medicineModel.addAttribute("id", id);
		medicineModel.addAttribute("msg", "medicine updated successfully");
		return "redirect:/medicines";
	}

	@GetMapping("/delete/medicine/{id}")
	public String deleteMedicine(@PathVariable int id, ModelMap medicineModel) {
		md.deleteMedicine(id);
		List<Medicine> medicines = md.getMedicines();
		medicineModel.addAttribute("categories", cd.getcategories());
		medicineModel.addAttribute("medicines", medicines);
		medicineModel.addAttribute("msg", "medicine delted successfully");
		return "redirect:/medicines";
	}

}
