package com.proj.java.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
public class Medicine {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name = "company_name")
  private String cname;
  
  @Column(name ="medicine_name")
  private String mname;
  
  @Column(name= "exp_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date edate;
  
  @Column(name ="mnf_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mdate;
  
  @Column(name="price")
  private int price;

  private String categoryname;
  
public Medicine() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public String getMname() {
	return mname;
}

public void setMname(String mname) {
	this.mname = mname;
}

public Date getEdate() {
	return edate;
}

public void setEdate(Date edate) {
	this.edate = edate;
}

public Date getMdate() {
	return mdate;
}

public void setMdate(Date mdate) {
	this.mdate = mdate;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getCategoryname() {
	return categoryname;
}

public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}

public Medicine(int id, String cname, String mname, Date edate, Date mdate, int price, String categoryname) {
	super();
	this.id = id;
	this.cname = cname;
	this.mname = mname;
	this.edate = edate;
	this.mdate = mdate;
	this.price = price;
	this.categoryname = categoryname;
}


  
}
