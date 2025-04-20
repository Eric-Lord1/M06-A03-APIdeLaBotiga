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

    @PostMapping("/postSubcategoria")
    public ResponseEntity<SubcategoriaDTO> inserirSubcategoria(@RequestBody SubcategoriaDTO dto) {
        Subcategoria entitat = mapper.toSubcategoria(dto);
        Subcategoria creada = subcategoriaService.save(entitat);
        return ResponseEntity.status(201).body(mapper.toSubcategoriaDTO(creada));
    }
}

