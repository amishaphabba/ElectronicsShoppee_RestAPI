package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Manager;
import com.example.demo.services.ManagerService;


@RestController
public class ManagerController {
	@Autowired
	ManagerService ms;
	
	/*Http Method: GET
    URL : http://localhost:8080/ElectronicProduct
    */
    
	@GetMapping("/Manager")
	public List<Manager> showAllManager() {
		return ms.showAllManager();
	}
	
	@PostMapping("/Manager")
	public String addManager(@RequestBody Manager manager ) {
		return ms.addManager(manager);
	}
	
	@DeleteMapping("/Manager")
	public String deleteAccounts(@PathVariable int manager_id) {
		return ms.deleteAccount(manager_id);
	}
	
}
