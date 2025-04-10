package com.ericayxendri.accesadades.botiga.repos;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;
import com.ericayxendri.accesadades.botiga.models.Product;

@Repository
public interface ProducteRepo extends JpaRepository {

    @Override
    @NonNull
    List<Product> findAll();
    Product findByName(String name);
    Set<Product> findByNameAndPrice(String name, float price);
}
