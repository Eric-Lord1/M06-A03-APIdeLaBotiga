package com.ericayxendri.accesadades.botiga.services;

import java.util.List;
import com.ericayxendri.accesadades.botiga.models.Product;

public interface ProductService {
 
    List<Product> findAllProducts();
    Product findProductsByName(String name);
    List<Product> findAllProducts(String subcategory);
    void increasePrice(Product product);
}
