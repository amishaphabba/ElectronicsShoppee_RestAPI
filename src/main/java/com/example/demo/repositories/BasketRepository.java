package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer>{

}

