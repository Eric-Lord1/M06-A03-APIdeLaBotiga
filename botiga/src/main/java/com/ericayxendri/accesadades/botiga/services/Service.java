package com.ericayxendri.accesadades.botiga.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.ericayxendri.accesadades.botiga.models.Product;

public interface Service {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product entity);
    void deleteById(Long id);
    
}
