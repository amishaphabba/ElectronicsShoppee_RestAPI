package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Basket;
import com.example.demo.entities.Customer;
import com.example.demo.entities.CustomerAddress;
import com.example.demo.entities.ElectronicProduct;
import com.example.demo.entities.ElectronicProductOrder;
import com.example.demo.entities.ElectronicProductType;
import com.example.demo.entities.Manager;
import com.example.demo.repositories.BasketRepository;
import com.example.demo.repositories.CustomerAddressRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ElectronicProductOrderDetailRepository;
import com.example.demo.repositories.ElectronicProductOrderRepository;
import com.example.demo.repositories.ElectronicProductRepository;
import com.example.demo.repositories.ElectronicProductTypeRepository;


@Service
public class CustomerService {
	
    @Autowired
    CustomerRepository cr;
    
    @Autowired
    CustomerAddressRepository car;
    
    @Autowired
	BasketRepository br;
	
	@Autowired
	ElectronicProductOrderDetailRepository epodr;
	
	@Autowired
	private ElectronicProductRepository epr;
	
	@Autowired
	ElectronicProductOrderRepository epor;
	
	@Autowired
	ElectronicProductTypeRepository eptr;

    public String showAllCustomers() {
        // TODO
        return cr.findAll().toString();
    }

    public String ShowCustomersOnId(int customer_id){
        Optional<Customer> cust = cr.findById(customer_id);
        if(cust.isPresent()){
            return cr.findById(customer_id).toString();
        }
        return "Customer Not found";
    }


  public String AddCustomer(Customer customer){      
  	if(customer.getCustomerEmail().isEmpty()) {
  		 return  "Add Valid EmailId";
  	}
  	if(customer.getCustomerName().isEmpty()) {
  		return  "Add Valid CustomerName";
  	}
  	if(customer.getCustomerPhone().isEmpty() || !(customer.getCustomerPhone().length()==10)) {
  		return  "Add Valid phone number";
  	}
  	Optional<Customer> cust = cr.findById(customer.getCustomer_id());
  	if(cust.isPresent()) {
  		return "customer with customer_id "+customer.getCustomer_id()+" is already present";
  	}
 	

  	List<ElectronicProduct> electronicProductList = customer.getElectronicProduct();
	double total=0;
	for(ElectronicProduct item : electronicProductList) {
//		ElectronicProductType ept = new ElectronicProductType();  //should not create new object as it is mapped(it creates double row)
		LocalDate today = LocalDate.now();
		item.setCreateDate(today);
		item.getElectronicProductType().setName(item.getName());
//		eptr.save(item);
		total+=item.getPrice();
	}
	customer.getBasket().setTotal(total);
	customer.getBasket().setProductCount(electronicProductList.size());
  	br.save(customer.getBasket());
	
	Set<ElectronicProductOrder> epoSet = customer.getElectronicProductOrderSet();
	for(ElectronicProductOrder item : epoSet) {
//		ElectronicProductOrder epo = new ElectronicProductOrder();
//		item.setCustomer_id(customer.getCustomer_id());
		item.setAmount(customer.getBasket().getTotal());
		item.setOrderDate(LocalDate.now());
		epor.save(item);
	}
	
  	cr.save(customer);
  	return "New Customer Added ";
  }


  public String UpdateCustomerDetails(Customer customer, int customer_id) {
	  Customer cust = cr.getById(customer.getCustomer_id());
	  if(cust!=null) {
//		  cust.setCustomer_id(customerId);
		  cust.setCustomerAddress(customer.getCustomerAddress());
		  cust.setCustomerEmail(customer.getCustomerEmail());
		  cust.setCustomerName(customer.getCustomerName());
		  cust.setCustomerPhone(customer.getCustomerPhone());
		  double total=0;
		  List<ElectronicProduct> ep = customer.getElectronicProduct();
		  for(ElectronicProduct item:ep) {
			  total+=item.getPrice();
			  item.setCreateDate(LocalDate.now());
		  }
		cust.setElectronicProduct(ep);
		  
		  Set<ElectronicProductOrder> epoSet = customer.getElectronicProductOrderSet();
			for(ElectronicProductOrder item1 : epoSet) {
//				item1.setCustomer_id(cust.getCustomer_id());
				item1.setAmount(customer.getBasket().getTotal());
				item1.setOrderDate(LocalDate.now());
//				epor.save(item1);
			}
		cust.setElectronicProductOrderSet(epoSet);
			cust.getBasket().setTotal(total);
			cust.getBasket().setProductCount(ep.size());
		 
//	  	 br.save(cust.getBasket());
		 cr.save(cust);
		 return "customer updated";
	  }
          
      
      return "Customer Not Found with Id" + customer_id;
  }

  public String DeleteCustomer(int customer_id) {
      //TODO Auto-generated Method stub;
      Optional<Customer> cust = cr.findById(customer_id);
      if (cust.isPresent()) {
          cr.deleteById(customer_id);
          return "Customer Deleted Successfully";
      }
      return "Customer Not Found With Id" + customer_id;
  }
      
}
