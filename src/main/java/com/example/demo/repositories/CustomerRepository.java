package com.example.demo.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
//	@Query("SELECT c from Customer c WHERE c.customer_id=?1")
//	 Basket findBycustomer_id(int customer_id);
	
//	@Query("SELECT s FROM Offers s WHERE s.product_id=?1")
//	Offers getOfferOnProductId(int product_id);


}
