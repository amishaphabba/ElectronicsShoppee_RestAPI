package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(name="account_id")
int account_id;
@Column(name="userName")
String userName;
@Column(name="password")
String password;
@Column(name="userRole")
String userRole;

public Account() {} //no argument constructor

public Account(String userName, String password, String userRole) {
	super();
	this.userName = userName;
	this.password = password;
	this.userRole = userRole;
}

public int getAccount_id() {
	return account_id;
}

public void setAccount_id(int account_id) {
	this.account_id = account_id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUserRole() {
	return userRole;
}

public void setUserRole(String userRole) {
	this.userRole = userRole;
}

@Override
public String toString() {
	return "Account {"
			+ "\n       account_id=" + account_id + ","
			+ "\n       userName=" + userName + ","
			+ "\n       password=" + password + ","
			+ "\n       userRole="+ userRole 
			+ "\n}";
}

	
}