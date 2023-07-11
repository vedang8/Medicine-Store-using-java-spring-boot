package com.proj.java.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.java.project.entity.Order;
import com.proj.java.project.entity.User;
import com.proj.java.project.repository.OrderDao;

@Service
public class OrderService {
//	
	@Autowired
	private OrderDao od;

	public Order getUser(final int id) {
		return od.getOrder(id);
	}
	
	public void addUser(final Order order) {
		od.addOrder(order);
	}

	public void deleteUser(final int id) {
		od.deleteOrder(id);
	}

}
