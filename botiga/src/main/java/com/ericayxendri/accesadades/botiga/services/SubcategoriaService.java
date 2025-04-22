package com.ericayxendri.accesadades.botiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericayxendri.accesadades.botiga.models.Subcategoria;
import com.ericayxendri.accesadades.botiga.repos.SubcategoriaRepo;

@Service
public class SubcategoriaService implements IService<Subcategoria, Long> {

    @Autowired
    private SubcategoriaRepo subcategoriaRepo;

    @Override
    public List<Subcategoria> findAll() {
        return subcategoriaRepo.findAll();
    }

    @Override
    public Optional<Subcategoria> findById(Long id) {
        return subcategoriaRepo.findById(id);
    }

    @Override
    public Subcategoria save(Subcategoria subcategoria) {
        return subcategoriaRepo.save(subcategoria);
    }

    @Override
    public void deleteById(Long id) {
        subcategoriaRepo.deleteById(id);
    }

    public Subcategoria findByName(String category) {
        return subcategoriaRepo.findByName(category);
    }

    public List<Subcategoria> findByNameMatch(String category) {
        return subcategoriaRepo.findByNameContaining(category);
    }

    public List<Subcategoria> findByStatus(String status) {
        return subcategoriaRepo.findByStatus(status);
    }
}
