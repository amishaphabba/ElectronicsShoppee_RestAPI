package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ElectronicProduct;
import com.example.demo.entities.ElectronicProductType;

@Repository
public interface ElectronicProductTypeRepository extends JpaRepository<ElectronicProductType , Integer> {

}
