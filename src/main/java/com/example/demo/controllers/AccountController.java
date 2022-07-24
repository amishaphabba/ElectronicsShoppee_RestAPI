package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;



@RestController
public class AccountController {
	
@Autowired
AccountService asi;

@GetMapping("/Account")
public List<Account> getAllAccounts(){
	return asi.getAllAccounts();
}
@GetMapping("/Account/{id}")
public Account getSingleAccount(@PathVariable int id) {
	return asi.getSingleAccount(id);
}
@PostMapping("/Account")
public String saveAccounts(@RequestBody Account a) {
	return asi.saveAccount(a);
}
@DeleteMapping("/Account/{account_id}")
public String deleteAccounts(@RequestParam int id) {
	return asi.deleteAccount(id);
}
@PutMapping("/Account/{id}")
public String updateAccounts(@PathVariable int id,@RequestBody Account a) {
return asi.updateAccount(id,a);
}
}