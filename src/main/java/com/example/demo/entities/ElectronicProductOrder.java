package com.example.demo.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ElectronicProductOrder")
public class ElectronicProductOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="epo_Id")
	private int epo_Id;
	
	@Column(name="orderDate")
	private LocalDate orderDate;
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="orderNum")
	private int orderNum;
	
	@Column(name="amount")
	private double amount;	

	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer")
//	int customer_id;
	
	
	public ElectronicProductOrder() {} 
	
	public ElectronicProductOrder( LocalDate orderDate, int orderNum,double amount) {
		super();
		this.orderDate= orderDate;
		this.orderNum = orderNum;
		this.amount = amount;
			
	}

	public int getEpo_Id() {
		return epo_Id;
	}

	public void setEpo_Id(int epo_Id) {
		this.epo_Id = epo_Id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "\nElectronicProductOrder {"
				+"\n       epo_Id=" + epo_Id + ","
				+"\n       orderDate=" + orderDate + ","
				+"\n       orderNum=" + orderNum + ","
				+"\n       amount="+ amount + ","
				+"\n}";
	}
	
}
