package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ElectronicProduct;

@Repository
public interface ElectronicProductRepository extends JpaRepository<ElectronicProduct , Integer> {

}
