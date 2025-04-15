package com.ericayxendri.accesadades.botiga.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.ericayxendri.accesadades.botiga.models.Categoria;

public interface CategoriaRepo extends JpaRepository<Categoria, Long> {

    @Override
    @NonNull
    List<Categoria> findAll();
    Categoria findByName(String category);
}
