package com.ericayxendri.accesadades.botiga.repos;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import com.ericayxendri.accesadades.botiga.models.Product;


@Repository
public interface ProducteRepo extends JpaRepository<Product, Long> {

    @Override
    @NonNull
    List<Product> findAll(); 
    Product findByName(String name);
    List<Product> findByNameAndPrice(String name, float price);
    List<Product> findByNomContainingIgnoreCase(String nom);

}