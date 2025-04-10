package com.ericayxendri.accesadades.botiga.repos;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.ericayxendri.accesadades.botiga.models.Subcategoria;

public interface SubcategoriaRepo extends JpaRepository {
    @Override
    @NonNull
    List<Subcategoria> findAll();
    Subcategoria findByName(String subcategory);
}
