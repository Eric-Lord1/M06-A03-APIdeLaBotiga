package com.ericayxendri.accesadades.botiga.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericayxendri.accesadades.botiga.models.Subcategoria;

import io.micrometer.common.lang.NonNull;

import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoriaRepo extends JpaRepository<Subcategoria, Long> {

    @Override
    @NonNull
    List<Subcategoria> findAll();
    Subcategoria findByName(String name);
}