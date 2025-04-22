
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
@RequestMapping("/api/botiga/categories")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private BotigaMapper mapper;

    @GetMapping("/getAllCategoria")
    public ResponseEntity<List<CategoriaDTO>> llistarCategories() {
        List<CategoriaDTO> dtos = categoriaService.findAll()
                .stream()
                .map(mapper::toCategoriaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/name")
    public ResponseEntity<List<CategoriaDTO>> getByNom(@RequestParam String name) {
        List<Categoria> categories = categoriaService.findByNameMatch(name);
        return ResponseEntity.ok(categories.stream().map(mapper::toCategoriaDTO).toList());
    }

    @GetMapping("/status")
    public ResponseEntity<List<CategoriaDTO>> getByStatus(@RequestParam String status) {
        List<Categoria> result = categoriaService.findByStatus(status);
        return ResponseEntity.ok(result.stream().map(mapper::toCategoriaDTO).toList());
    }

    @PostMapping("/postCategoria")
    public ResponseEntity<CategoriaDTO> inserirCategoria(@RequestBody CategoriaDTO dto) {
        Categoria entitat = mapper.toCategoria(dto);
        Categoria creada = categoriaService.save(entitat);
        return ResponseEntity.status(201).body(mapper.toCategoriaDTO(creada));
    }
}
