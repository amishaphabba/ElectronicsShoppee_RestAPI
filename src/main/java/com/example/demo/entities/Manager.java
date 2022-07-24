package com.example.demo.entities;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Manager")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int manager_id;
	
	@Column(name="passowrd")
	String password; 
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_account")
	Account account;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_customer")
	Customer customer;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_electronicProduct")
	ElectronicProduct product;
	
	public Manager() {}  //no argument constructor

	

	public Manager(int manager_id, String password, Account account, Customer customer, ElectronicProduct product) {
		super();
		this.manager_id = manager_id;
		this.password = password;
		this.account = account;
		this.customer = customer;
		this.product = product;
	}


	public int getManager_id() {
		return manager_id;
	}


	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public ElectronicProduct getProduct() {
		return product;
	}

	public void setProduct(ElectronicProduct product) {
		this.product = product;
	}	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "\n Manager {"
				+ "\n       manager_id=" + manager_id + ","
				+ "\n       password=" + password + ","
				+ "\n       account=" + account + ","
				+ "\n       customer="+ customer + ","
				+ "\n       product=" + product + 
				"\n}";
	}

}