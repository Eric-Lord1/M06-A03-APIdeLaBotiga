package com.ericayxendri.accesadades.botiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericayxendri.accesadades.botiga.models.Categoria;
import com.ericayxendri.accesadades.botiga.repos.CategoriaRepo;

@Service
public class CategoriaService implements IService<Categoria, Long> {

    @Autowired
    private CategoriaRepo categoriaRepo;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepo.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepo.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepo.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepo.deleteById(id);
    }

    public Categoria findByName(String category) {
        return categoriaRepo.findByName(category);
    }
}

