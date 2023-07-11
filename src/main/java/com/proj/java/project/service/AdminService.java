package com.proj.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.proj.java.project.repository.AdminDao;
import com.proj.java.project.repository.MedicineDao;

@Service
public class AdminService {
    
	@Autowired
	private AdminDao ad;
	
	public boolean login(String email,String password) {
		return ad.validate(email, password);
	}
	
	
}
