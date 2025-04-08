package com.ericayxendri.accesadades.botiga.services;

import java.util.Set;
import com.ericayxendri.accesadades.botiga.models.Product;

public interface ProductService {
 
    Set<Product> findAllProducts();
    Product findProductsByName(String name);
    Set<Product> findAllProducts(String subcategory);
    void increasePrice(Product product);
}
