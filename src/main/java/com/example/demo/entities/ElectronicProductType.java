package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="ElectronicProductType")
public class ElectronicProductType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prdType_id;
	
	@Column(name = "name")
	String name;
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="productType")
//	ElectronicProduct electronicProduct;
	

	public ElectronicProductType() {}
	
	
	
	
	public ElectronicProductType(int prdType_id, String name) {
		super();
		this.prdType_id = prdType_id;
		this.name = name;
	}




	public int getPrdType_id() {
		return prdType_id;
	}

	public void setPrdType_id(int prdType_id) {
		this.prdType_id = prdType_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n       ElectronicProductType {"
				+ "\n              prdType_id=" + prdType_id + ","
				+ "\n              name=" + name 
				+ "\n}";
	}
	
//	public ElectronicProduct getElectronicProduct() {
//		return electronicProduct;
//	}
//
//	public void setElectronicProduct(ElectronicProduct electronicProduct) {
//		this.electronicProduct = electronicProduct;
//	}

	
	
	
}
