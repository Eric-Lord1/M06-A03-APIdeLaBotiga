package com.ericayxendri.accesadades.botiga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.ericayxendri.accesadades.botiga.models.Product;
import com.ericayxendri.accesadades.botiga.repos.ProducteRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProducteRepo productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllProducts(String subcategory) {
        return null;
    }

    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void increasePrice(Product product) {

    }
}

