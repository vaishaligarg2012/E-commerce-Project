package com.MVCStart.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="Supplier")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int supplierId;
	@Column(name="Name")
	private String supplierName;
	
	@Column(name="Email")
	private String supplierEmail;

	@Column(name="Mobile")
	private String supplierMobile;
	
	@OneToOne
	@JoinColumn(name="AddressId")
	private Address address;
	

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	public String getSupplierMobile() {
		return supplierMobile;
	}
	public void setSupplierMobile(String supplierMobile) {
		this.supplierMobile = supplierMobile;
	}

}
