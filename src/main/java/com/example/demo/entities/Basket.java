package com.example.demo.entities;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "Basket")
public class Basket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int basket_id;
	
	@Column(name= "productCount")
	int productCount;
	
	@Column(name= "total")
	double total;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "electronicProductList")
	List<ElectronicProduct> productList;
	
	//Unidirectional one to one mapping
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "epod_id")
//	private ElectronicProductOrderDetail electronicProductOrderDetail;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Basket", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("Basket")
//    private ElectronicProduct electronicProduct;

    public Basket() {
		
	}

	

	

	public Basket(int basket_id, int productCount, double total, List<ElectronicProduct> productList) {
		super();
		this.basket_id = basket_id;
		this.productCount = productCount;
		this.total = total;
		this.productList = productList;
	}





	public int getBasket_id() {
		return basket_id;
	}

	public void setBasket_id(int basket_id) {
		this.basket_id = basket_id;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
	
	public List<ElectronicProduct> getProductList() {
		return productList;
	}



	public void setProductList(List<ElectronicProduct> productList) {
		this.productList = productList;
	}



	@Override
	public String toString() {
		return "\nBasket {"
				+ "\n       basket_id=" + basket_id + ","
				+ "\n       productCount=" +productCount + ","
				+ "\n       total=" + total+ ","
				+ "\n       productList=" + productList +
				"}";
	}

//
//
//	public ElectronicProductOrderDetail getElectronicProductOrderDetail() {
//		return electronicProductOrderDetail;
//	}
//
//	public void setElectronicProductOrderDetail(ElectronicProductOrderDetail electronicProductOrderDetail) {
//		this.electronicProductOrderDetail = electronicProductOrderDetail;
//	}

	
    
    }
