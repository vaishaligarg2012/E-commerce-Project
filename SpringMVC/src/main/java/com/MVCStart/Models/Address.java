package com.MVCStart.Models;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SupplierAddress")
public class Address {
	    
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int addressId;
	    private String addressLine;
	    private String city;
	    private String state;
		private int pincode;
		
	
		public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

		public String getAddressLine() {
			return addressLine;
		}

		public void setAddressLine(String addressLine) {
			this.addressLine = addressLine;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getPincode() {
			return pincode;
		}

		public void setPincode(int pincode) {
			this.pincode = pincode;
		}

		
}
