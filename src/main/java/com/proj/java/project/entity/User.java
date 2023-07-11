package com.proj.java.project.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

@Entity
@Table(name = "user_table")
public class User {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column(length = 500)
	private String address;
	
	@Column
	private String mobileno;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> orderlist = new ArrayList<>();

	public User(int id, String name, String username, String password, String address, String mobileno,
			List<Order> orderlist) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobileno = mobileno;
		this.orderlist = orderlist;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileno() {
		return mobileno;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", address="
				+ address + ", mobileno=" + mobileno + ", orderlist=" + orderlist + "]";
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public List<Order> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}
	
	
}
