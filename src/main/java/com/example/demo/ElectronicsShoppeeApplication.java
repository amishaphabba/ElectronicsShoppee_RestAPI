package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//public class ElectronicsShoppeeApplication implements CommandLineRunner
public class ElectronicsShoppeeApplication{

	public static void main(String[] args) {
		SpringApplication.run(ElectronicsShoppeeApplication.class, args);
		System.out.println("Started.......");
	}
	
//	@Autowired
//	ElectronicProductTypeRepository electronicProductTypeRepository;
//	
//	@Autowired
//	ElectronicProductRepository electronicProductRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		//ElectronicProduct object
//		ElectronicProduct ep = new ElectronicProduct();
//		ep.setCode("LAPTOP21DELL");
//		ep.setCreateDate(LocalDate.of(2022, 07, 13));
//		ep.setName("DELL Laptop");
//		ep.setPrice(55000);
//		
//		//ElectronicProductType object
//		ElectronicProductType ept = new ElectronicProductType();
//		ept.setName("DELL Laptop");
//		
//		ep.setProductType(ept);
//		ept.setElectronicProduct(ep);
//		
//		electronicProductRepository.save(ep);	
////		electronicProductTypeRepository.save(ept);
//	}

}
