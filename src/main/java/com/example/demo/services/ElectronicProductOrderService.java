package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.ElectronicProduct;
import com.example.demo.entities.ElectronicProductOrder;
import com.example.demo.entities.ElectronicProductType;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ElectronicProductOrderRepository;

@Service
public class ElectronicProductOrderService{
	@Autowired
	ElectronicProductOrderRepository epor;
	
	@Autowired
	CustomerRepository cr;

	public List<ElectronicProductOrder> showAllProductOrders() {
		// TODO 
		return  epor.findAll();
	}

	public String showAllProductOrdersOnId(int prdOrderId) {
		// TODO 
		Optional<ElectronicProductOrder> epo  = epor.findById(prdOrderId);
		if(epo.isPresent()) {
			return epor.findById(prdOrderId).toString();
		}
		return "no product type found by id "+prdOrderId;	
	}

	public String addProductOrder(ElectronicProductOrder electronicProductOrder) {
		// TODO 
		
		if(String.valueOf(electronicProductOrder.getAmount()).isEmpty() || String.valueOf(electronicProductOrder.getOrderNum()).isEmpty() ||String.valueOf(electronicProductOrder.getOrderDate()).isEmpty()) {
			return "Add correct input";
		}
//		electronicProductOrder.setCustomer(null);
		electronicProductOrder.setOrderDate(LocalDate.now());
		epor.save(electronicProductOrder);
        return "Product Order saved "+electronicProductOrder.toString();
		
	}

	public String updateProductOrder(ElectronicProductOrder electronicProductOrder, int prdOrderId) {
		// TODO 
		Optional<ElectronicProductOrder> epo  = epor. findById(prdOrderId);
		if(epo.isPresent()) {
			return "Product order updated "+epor.save(electronicProductOrder).toString();
		}
		return "No product order with id "+prdOrderId;
	}

	public String cancelProductOrder(int prdOrderId) {
		// TODO Auto-generated method stub
		Optional<ElectronicProductOrder> epo  = epor. findById(prdOrderId);
		if(epo.isPresent()) {
			epor.deleteById(prdOrderId);
			return "Product order deleted";
		}
		return "No product order with id "+prdOrderId;
		
	}
	

}
