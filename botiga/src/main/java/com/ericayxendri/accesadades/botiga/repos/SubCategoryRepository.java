package com.ericayxendri.accesadades.botiga.repos;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface SubCategoryRepository extends JpaRepository {
    @Override
    @NonNull
    List<SubCategory> findAll();
    SubCategory findByName(String subcategory);
}
