package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.ElectronicProduct;
import com.example.demo.entities.ElectronicProductType;
import com.example.demo.entities.Manager;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ElectronicProductRepository;
import com.example.demo.repositories.ManagerRepository;


@Service
public class ManagerService {
	@Autowired
	private ManagerRepository mr;
	@Autowired
	CustomerRepository cr;
	@Autowired
	AccountRepository ar;
	@Autowired
	ElectronicProductRepository epr;
	
	public List<Manager> showAllManager() {
		// TODO Auto-generated method stub
		return  mr.findAll();
	}
	
	public String addManager(Manager manager) {
		// TODO Auto-generated method stub
		LocalDate today = LocalDate.now();
		manager.getProduct().setCreateDate(today);
		manager.setAccount(ar.getById(manager.getAccount().getAccount_id()));
		manager.setCustomer(cr.getById(manager.getCustomer().getCustomer_id()));
		manager.setProduct(epr.getById(manager.getProduct().getProduct_id()));
		manager.setPassword(manager.getAccount().getPassword());
		mr.save(manager);
		return "manager saved "+ manager.toString();
		
	}

	public String deleteAccount(int manager_id) {
		// TODO Auto-generated method stub
		Optional<Manager> mn  = mr.findById(manager_id);
		if(mn.isPresent()) {
			mr.deleteById(manager_id);
			return "Product deleted";
		}
		return "No product with id "+manager_id;
	}

}