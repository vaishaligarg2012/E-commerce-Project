package com.MVCStart.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
      
	   @Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   @Column(name="Id")
	   private int catId;
	   
	   @Column(name="Name")
       private String catName;
	   
	   @Column(name="Description")
       private String catDescription;
	   
	   public void setCatId(int catId) {
		   this.catId=catId;
	   }
	   
	   public int getCatId() {
		   return catId;
	   }

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDescription() {
		return catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
}
