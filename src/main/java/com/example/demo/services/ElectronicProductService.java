package com.example.demo.services;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ElectronicProduct;
import com.example.demo.entities.ElectronicProductType;
import com.example.demo.repositories.ElectronicProductRepository;
import com.example.demo.repositories.ElectronicProductTypeRepository;


@Service
public class ElectronicProductService{
	
	@Autowired
	private ElectronicProductRepository epr;
	
	@Autowired
	private ElectronicProductTypeRepository eptr;
	
	public List<ElectronicProduct> showAllProducts() {
		// TODO Auto-generated method stub
		return  epr.findAll();
	}
	
	public String showAllProductsOnId(int productId) {
		// TODO Auto-generated method stub
		Optional<ElectronicProduct> ep  = epr. findById(productId);
		if(ep.isPresent()) {
			return epr.findById(productId).toString();
		}
		return "no product type found by id "+productId;
	}
	
	public String addProduct(ElectronicProduct electronicProduct ) {
		
		if(String.valueOf(electronicProduct.getPrice()).isEmpty() || String.valueOf(electronicProduct.getCreateDate()).isEmpty() || String.valueOf(electronicProduct.getName()).isEmpty() ||String.valueOf(electronicProduct.getElectronicProductType())== null) {
			return "Add correct input";
		}
		epr.save(electronicProduct);
		
	    return "Product saved "+electronicProduct.toString();
		
	}
	
	public String updateProduct(ElectronicProduct electronicProduct, int productId) {
		// TODO Auto-generated method stub
		Optional<ElectronicProduct> ep  = epr. findById(productId);
		if(ep.isPresent()) {
			return "Product updated "+epr.save(electronicProduct).toString();
		}
		return "No product with id "+productId;
	}
	
	public String cancelProduct(int productId) {
		// TODO Auto-generated method stub
		Optional<ElectronicProduct> ep  = epr. findById(productId);
		if(ep.isPresent()) {
			epr.deleteById(productId);
			return "Product deleted";
		}
		return "No product with id "+productId;
		
	}



}