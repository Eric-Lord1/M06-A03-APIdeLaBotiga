package com.ericayxendri.accesadades.botiga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.ericayxendri.accesadades.botiga.models.Product;
import com.ericayxendri.accesadades.botiga.repos.ProducteRepo;
@Service
public class ProductService implements IService<Product, Long> {

    @Autowired
    private ProducteRepo productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findByNameContaining(String nom) {
        return productRepository.findByNomContainingIgnoreCase(nom);
    }
    
    public boolean updateProductPrice(Long id, Long nouPreu) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(nouPreu);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    

}
