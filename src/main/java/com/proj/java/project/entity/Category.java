package com.proj.java.project.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String name;
    
    
    @Column
    private String description;
    
    @OneToMany
    List<Medicine> medicinelist = new ArrayList<Medicine>();
    
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    
    public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
        return id;
    }
    
	
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Category(Long id, String name, String description, List<Medicine> medicinelist) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.medicinelist = medicinelist;
	}


	public List<Medicine> getMedicinelist() {
		return medicinelist;
	}


	public void setMedicinelist(List<Medicine> medicinelist) {
		this.medicinelist = medicinelist;
	}


	public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

    
}
