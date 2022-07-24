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
import com.example.demo.entities.Basket;
import com.example.demo.services.BasketService;


@RestController
public class BasketController {

	
	@Autowired
	BasketService bsi;
	
	@GetMapping("/Basket")
	public List<Basket> showAllBasket() {
		return bsi.showAllBasket();
	}
	
	@GetMapping("/Basket/{basketId}")
	public String showAllBasketOnId(@PathVariable int basketId) {
		return bsi.showAllBasketOnId(basketId);
	}
	
	@PostMapping("/Basket")
	public String addBasket(@RequestBody Basket basket ) {
		return bsi.addBasket(basket);
	}
	
	@PutMapping("/Basket/{basketId}")
	public String updateBasket(@RequestBody Basket basket, @PathVariable int basketId) {
		return bsi.updateBasket(basket,basketId);
	}
	
	@DeleteMapping("/Basket/{basketId}")
	public String cancelBasket(@PathVariable int basketId) {
		return bsi.cancelBasket(basketId);	
	}
  	
	@GetMapping("/Basket/totalCost")
	public double totalCost()
	{
		return bsi.totalCost();
	}
	
}
