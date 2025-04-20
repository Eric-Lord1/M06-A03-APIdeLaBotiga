package com.ericayxendri.accesadades.botiga.repos;

import org.springframework.stereotype.Repository;

import com.ericayxendri.accesadades.botiga.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;


@Repository
public interface ProducteRepo extends JpaRepository<Product, Long> {

    @Override
    @NonNull
    List<Product> findAll(); 

    Product findByName(String name);

    List<Product> findByNameAndPrice(String name, float price);
    
    List<Product> findByNameContainingIgnoreCase(String name);

}