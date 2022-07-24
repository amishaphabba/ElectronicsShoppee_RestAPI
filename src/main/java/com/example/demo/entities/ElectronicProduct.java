package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="ElectronicProduct")
public class ElectronicProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int product_id;
	
	@Column(name="name")
	String name;
	
	@Column(name="price")
	double price;
	
	@Column(name="createDate")
	LocalDate createDate;
	
	//Unidirectional one to one mapping
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "productTypeId", referencedColumnName = "prdType_id")
	ElectronicProductType electronicProductType;
	
	public ElectronicProduct() {} //no argument constructor

	public ElectronicProduct(String name, double price, LocalDate createDate,
			ElectronicProductType electronicProductType) {
		super();
		this.name = name;
		this.price = price;
		this.createDate = createDate;
		this.electronicProductType = electronicProductType;
	}


	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public ElectronicProductType getElectronicProductType() {
		return electronicProductType;
	}

	public void setElectronicProductType(ElectronicProductType electronicproductType) {
		this.electronicProductType = electronicproductType;
	}

	@Override
	public String toString() {
		return "\nElectronicProduct {"
				+ "\n       product_id=" + product_id + ","
			    + "\n       name=" + name + ","
			    + "\n       price=" + price + ","
			    + "\n       createDate="+ createDate + ","
			    + "\n       electronicProductType=" + electronicProductType 
			    + "\n       }";
	}

	
	
}
