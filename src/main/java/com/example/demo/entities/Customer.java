package com.example.demo.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="Customer")
public class Customer {


    @Id
    @Column(name = "customer_id")
    private int customer_id;
    
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "customerEmail")
    private String customerEmail;
    @Column(name = "customerPhone")
    private String customerPhone;
    
    //OneToOne customer to customeraddress
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_customer")
    CustomerAddress customerAddress;
    
    //many To one - Customer To  basket
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_basketId")
    private Basket basket;

//    //Unidirectionl mapping   
//      @OneToOne(cascade=CascadeType.ALL)
//	  @JoinColumn(name ="fk_manager")
//	  Manager manager;

    //one to many - customer to electronic product
//    @OneToMany
//    @JoinColumn(name = "productId")
//    private List<ElectronicProduct> electronicProduct;
      
    //one to many - customer to electronic product
      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "electronicProductList")
      private List<ElectronicProduct> electronicProduct;

    //One To Many - Customer To Electronic Product Order
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "electronicProductOrder")
    private Set<ElectronicProductOrder> electronicProductOrderSet;

    
    public Customer() {
    }

	public Customer(int customer_id, String customerName, String customerEmail, String customerPhone,
			CustomerAddress customerAddress, Basket basket, List<ElectronicProduct> electronicProduct,
			Set<ElectronicProductOrder> electronicProductOrderSet) {
		super();
		this.customer_id = customer_id;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.basket = basket;
		this.electronicProduct = electronicProduct;
		this.electronicProductOrderSet = electronicProductOrderSet;
	}



	


	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}



	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Basket getBasket() {
		return basket;
	}


	public void setBasket(Basket basket) {
		this.basket = basket;
	}


//	public Manager getManager() {
//		return manager;
//	}
//
//
//	public void setManager(Manager manager) {
//		this.manager = manager;
//	}


	public List<ElectronicProduct> getElectronicProduct() {
		return electronicProduct;
	}


	public void setElectronicProduct(List<ElectronicProduct> electronicProduct) {
		this.electronicProduct = electronicProduct;
	}


	public Set<ElectronicProductOrder> getElectronicProductOrderSet() {
		return electronicProductOrderSet;
	}


	public void setElectronicProductOrderSet(Set<ElectronicProductOrder> electronicProductOrderSet) {
		this.electronicProductOrderSet = electronicProductOrderSet;
	}

	@Override
	public String toString() {
		return "\nCustomer {"
				+ "\n       customer_id=" + customer_id + ","
				+ "\n       customerName=" + customerName + ","
				+ "\n       customerEmail="+ customerEmail + ","
				+ "\n       customerPhone=" + customerPhone + ","
				+ "\n       customerAddress=" + customerAddress+ ","
				+ "\n       basket=" + basket + ","
				+ "\n       electronicProduct=" + electronicProduct 
				+ "\n       electronicProductOrderSet="+electronicProductOrderSet
				+ "}";
	}



	
	 

    
}

