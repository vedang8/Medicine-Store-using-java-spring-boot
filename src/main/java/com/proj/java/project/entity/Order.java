package com.proj.java.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="order_table")
public class Order {
     
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 
	 @Column
	 private String CustomerName;
	 
	 @Column
	 private String mobileno;
	 
	 @Column
	 private String address;
	 
	 @Column(name = "medicine_name")
	 private String mname;
	 
	 @Column(name="company_name")
	 private String cname;
	 
	  @Column(name ="order_date")
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date odate;
	  
	  @Column
	  private int price;
	  
	  public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@ManyToOne
	  private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, String customerName, String mobileno, String address, String mname, String cname, Date odate) {
		super();
		this.id = id;
		CustomerName = customerName;
		this.mobileno = mobileno;
		this.address = address;
		this.mname = mname;
		this.cname = cname;
		this.odate = odate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", CustomerName=" + CustomerName + ", mobileno=" + mobileno + ", address=" + address
				+ ", mname=" + mname + ", cname=" + cname + ", odate=" + odate + "]";
	}

	public Date getOdate() {
		return odate;
	}

	public void setOdate(Date odate) {
		this.odate = odate;
	}

	 
}
