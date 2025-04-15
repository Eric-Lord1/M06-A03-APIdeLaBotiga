package com.ericayxendri.accesadades.botiga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.Set;
import com.ericayxendri.accesadades.botiga.models.Product;
import com.ericayxendri.accesadades.botiga.repos.ProductRepo;

@Service
public class ProductServiceImpl implements Service {

    @Override
    public Class<? extends Annotation> annotationType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'annotationType'");
    }

    @Override
    public String value() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'value'");
    }

    

    /*@Autowired
    private ProductRepository productRepository;

    @Override
    public Set<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Set<Product> findAllProducts(String subcategory) {
        return null;
    }

    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void increasePrice(Product product) {

    }*/
}

