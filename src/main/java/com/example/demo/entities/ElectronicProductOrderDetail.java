package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ElectronicProductOrderDetail")
public class ElectronicProductOrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int epod_id;
	
	@Column(name="quantity")
	int quantity;
	
	@Column(name = "amount")
	double amount;
	
	@Column(name ="productList")
	@ElementCollection(targetClass=ElectronicProduct.class)
	List<ElectronicProduct> productList;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="electronicProductOrderDetail")
//	Basket basket;
	
	

	public ElectronicProductOrderDetail() {
		
	}
	




	public ElectronicProductOrderDetail(int quantity, double amount, List<ElectronicProduct> productList) {
	super();
	this.quantity = quantity;
	this.amount = amount;
	this.productList = productList;
}





	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	

	public int getEpod_id() {
		return epod_id;
	}

	public void setEpod_id(int epod_id) {
		this.epod_id = epod_id;
	}

	public List<ElectronicProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<ElectronicProduct> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "\nElectronicProductOrderDetail {"
				+ "\n       epod_id=" + epod_id + ","
				+ "\n       quantity=" + quantity + ","
				+ "\n       amount=" + amount+ ","
				+ "\n       productList=" + productList +
				"\n}";
	}
	
}
