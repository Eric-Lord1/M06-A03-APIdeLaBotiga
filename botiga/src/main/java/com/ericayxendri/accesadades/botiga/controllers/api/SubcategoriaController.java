package com.ericayxendri.accesadades.botiga.controllers.api;

import com.ericayxendri.accesadades.botiga.Dto.*;
import com.ericayxendri.accesadades.botiga.mapper.BotigaMapper;
import com.ericayxendri.accesadades.botiga.models.*;
import com.ericayxendri.accesadades.botiga.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/botiga/subcategories")
class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @Autowired
    private BotigaMapper mapper;

    @GetMapping("/getAllSubcategoria")
    public ResponseEntity<List<SubcategoriaDTO>> llistarSubcategories() {
        List<SubcategoriaDTO> dtos = subcategoriaService.findAll()
                .stream()
                .map(mapper::toSubcategoriaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/name")
    public ResponseEntity<List<SubcategoriaDTO>> getByNom(@RequestParam String name) {
        List<Subcategoria> categories = subcategoriaService.findByNameMatch(name);
        return ResponseEntity.ok(categories.stream().map(mapper::toSubcategoriaDTO).toList());
    }

    @GetMapping("/status")
    public ResponseEntity<List<SubcategoriaDTO>> getByStatus(@RequestParam String status) {
        List<Subcategoria> result = subcategoriaService.findByStatus(status);
        return ResponseEntity.ok(result.stream().map(mapper::toSubcategoriaDTO).toList());
    }

    @PostMapping("/postSubcategoria")
    public ResponseEntity<SubcategoriaDTO> inserirSubcategoria(@RequestBody SubcategoriaDTO dto) {
        Subcategoria entitat = mapper.toSubcategoria(dto);
        Subcategoria creada = subcategoriaService.save(entitat);
        return ResponseEntity.status(201).body(mapper.toSubcategoriaDTO(creada));
    }
}

