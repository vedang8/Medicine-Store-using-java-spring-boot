package com.proj.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.java.project.entity.User;
import com.proj.java.project.repository.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao ud;

	public User getUser(final int id) {
		return ud.getUser(id);
	}
//	public Student getStudentByEmail(final String email) {
//		return studentDAO.getStudentByEmail(email);
//	}

	public List<User> getUsers() {
		return ud.getUsers();
	}

	public void addUser(final User student) {
		ud.addUser(student);
	}

	public void updateUser(final User u) {
		ud.updateUser(u);
	}
//
	public void deleteUser(final int id) {
		ud.deleteUser(id);
	}
	
	public User login(String email,String password) {
		return ud.validate(email, password);
	}

}
