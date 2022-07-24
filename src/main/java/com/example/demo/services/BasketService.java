package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Basket;
import com.example.demo.entities.ElectronicProduct;
import com.example.demo.entities.ElectronicProductOrderDetail;
import com.example.demo.repositories.BasketRepository;
import com.example.demo.repositories.ElectronicProductOrderDetailRepository;
import com.example.demo.repositories.ElectronicProductRepository;

@Service
public class BasketService{

	@Autowired
	BasketRepository br;
	
	@Autowired
	ElectronicProductOrderDetailRepository epodr;
	
	@Autowired
	private ElectronicProductRepository epr;
	
	public List<Basket> showAllBasket() {
		// TODO Auto-generated method stub
		return  br.findAll();
	}
	
	public String showAllBasketOnId(int basketId) {
		// TODO Auto-generated method stub
		Optional<Basket> basketItem  = br. findById(basketId);
		if(basketItem.isPresent()) {
			return br.findById(basketId).toString();
		}
		return "no basket found by id "+basketId;
	}
	
	/*
	  {
         "productCount":2,
    	 "total":100.0,
    	 "productList":[
         	"earphones",
         	"headphones"
    	 ]
	 }
	 
	 SQL
	 select epod.epod_id,list.product_list from electronic_product_order_detail  epod inner join electronic_product_order_detail_product_list list on epod.epod_id = list.electronic_product_order_detail_epod_id;;
	 select * from electronic_product_order_detail;
	 select * from electronic_product_order_detail_product_list;

	 */
	
	public String addBasket(Basket basket) {
		// TODO Auto-generated method stub
		
		if(String.valueOf(basket.getProductCount()).isEmpty() || String.valueOf(basket.getTotal()).isEmpty() || String.valueOf(basket.getProductList()).isEmpty() ) {
			System.out.println("in if");
			return "Add correct input";
		}
		
	
		
//		ElectronicProductOrderDetail electronicProductOrderDetail = new ElectronicProductOrderDetail();
//		electronicProductOrderDetail.setProductList(basket.getProductList());
//		electronicProductOrderDetail.setAmount(basket.getTotal());
//		electronicProductOrderDetail.setQuantity(basket.getProductCount());
//		basket.setElectronicProductOrderDetail(electronicProductOrderDetail);
//		epodr.save(electronicProductOrderDetail);
//		List<ElectronicProduct> basketList = basket.getProductList();
//		basket.setProductCount(basketList.size());
//		double total=0;
//		for(ElectronicProduct item :basketList) {
//			total+=item.getPrice();
//		}
//		basket.setTotal(total);
//		List<ElectronicProduct> electronicProductList = basket.getProductList();
//		for( ElectronicProduct item: electronicProductList) {
//			ElectronicProduct ep = new ElectronicProduct();
//			LocalDate today = LocalDate.now();
//			ep.setCreateDate(today);
//			ep.setName(item.getName());
//			ep.setPrice(item.getPrice());
//			ep.setElectronicProductType(item.getElectronicProductType());
//			epr.save(ep);
//		}
		br.save(basket);
		return "basket saved "+ basket.toString();
	}

	
	public String updateBasket(Basket basket, int basketId) {
		// TODO Auto-generated method stub
		Optional<Basket> b  = br.findById(basketId);
		if(b.isPresent()) {
			return "Basket updated "+br.save(basket).toString();
		}
		return "No Basket-id "+basketId;
	}
	
	public String cancelBasket(int basketId) {
		// TODO Auto-generated method stub
		Optional<Basket> b  = br.findById(basketId);
		if(b.isPresent()) {
			br.deleteById(basketId);
			return "Basket deleted";
		}
		return "No Basket-id "+basketId;
		
	}

	public double totalCost() {
		// TODO Auto-generated method stub
		double TotalCost = 0;
		List<Basket> basketItems = br.findAll();
		for(Basket item : basketItems) {
			TotalCost += item.getTotal();
		}
		return TotalCost;
	}


}