package com.ericayxendri.accesadades.botiga.repos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.ericayxendri.accesadades.botiga.models.Product;

public interface CategoryRepository extends JpaRepository {

    @Override
    @NonNull
    List<Category> findAll();
    Category findByName(String category);
    //List<Category> findByNameAndPrice(String name, float price);
}
