package com.ericayxendri.accesadades.botiga.repos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ericayxendri.accesadades.botiga.models.Subcategoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

@Repository
public interface SubcategoriaRepo extends JpaRepository<Subcategoria, Long> {

    @Override
    @NonNull
    List<Subcategoria> findAll();

    Subcategoria findByName(String name);

    List<Subcategoria> findByNameContaining(String status);

    List<Subcategoria> findByStatus(String status);

}