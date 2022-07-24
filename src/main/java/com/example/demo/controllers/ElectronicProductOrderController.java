package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ElectronicProductOrder;
import com.example.demo.services.ElectronicProductOrderService;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
public class ElectronicProductOrderController {
	@Autowired
	ElectronicProductOrderService epos;

	@GetMapping("/ElectronicProductOrder")
	public List<ElectronicProductOrder> showAllProductOrders() {
			return epos.showAllProductOrders();
	}

	@GetMapping("/ElectronicProductOrder/{prdOrderId}")
	public String showAllProductOrdersOnId(@PathVariable int prdOrderId) {
			return epos.showAllProductOrdersOnId(prdOrderId);
	}

	@PostMapping("/ElectronicProductOrder")
	public String addProductOrder(@RequestBody ElectronicProductOrder electronicProductOrder ) {
			return epos.addProductOrder(electronicProductOrder);
	}

	@PutMapping("/ElectronicProductOrder/{prdOrderId}")
	public String updateProductOrder(@RequestBody ElectronicProductOrder electronicProductOrder, @PathVariable int prdOrderId) {
			return epos.updateProductOrder(electronicProductOrder,prdOrderId);
	}

	@DeleteMapping("/ElectronicProductOrder/{prdOrderId}")
	public String cancelProductOrder(@PathVariable int prdOrderId) {
			return epos.cancelProductOrder(prdOrderId); 
	}
}
