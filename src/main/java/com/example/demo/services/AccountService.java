package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;


@Service
public class AccountService{
@Autowired
private AccountRepository ar;

	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	public Account getSingleAccount(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}

	public String saveAccount(Account obj1) {
		// TODO Auto-generated method stub
	 Optional<Account> a=ar.findById(obj1.getAccount_id());
	 if(a.isPresent()) {
		 return "Account with id " +obj1.getAccount_id()+" already exists !";
	 }
	 
	 ar.save(obj1);
	 return "Account added succesfully";
	}

	public String updateAccount(int id, Account obj1) {
		// TODO Auto-generated method stub
		try {
			Account a=ar.getById(id);
			a.setAccount_id(obj1.getAccount_id());
			a.setUserName(obj1.getUserName());
			a.setPassword(obj1.getPassword());
			a.setUserRole(obj1.getUserRole());
			ar.save(a);
			return a.toString();
		}
		catch(Exception e) {
			return "No Account with id "+id+" exists!";
		}
	}

	public String deleteAccount(int id) {
		// TODO Auto-generated method stub
		try {
			   ar.deleteById(id);
			   return "Deleted the details of id " +id;
			}
			catch(Exception e) {
				return "No Account Found with id "+id;
			}
	}

}
