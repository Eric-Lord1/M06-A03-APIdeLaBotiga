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
@RequestMapping("/api/botiga/productes")
class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SubcategoriaService subcategoriaService;

    @Autowired
    private BotigaMapper mapper;

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductDTO>> llistarProductes() {
        List<ProductDTO> dtos = productService.findAll()
                .stream()
                .map(mapper::toProducteDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/getByNameProduct")
    public ResponseEntity<List<ProductDTO>> cercaPerNom(@RequestParam String name) {
        List<ProductDTO> dtos = productService.findByNameContaining(name)
                .stream()
                .map(mapper::toProducteDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/postProduct")
    public ResponseEntity<ProductDTO> inserirProducte(@RequestBody ProductDTO dto) {
        Product entitat = mapper.toProducte(dto);
        Subcategoria sub = subcategoriaService.findByName(dto.getSubcategoria().getName());
        entitat.setSubcategoria(sub);

        Product creat = productService.save(entitat);
        return ResponseEntity.ok(mapper.toProducteDTO(creat));
    }

    @PutMapping("/putProductPreu")
    public ResponseEntity<String> modificarPreu(
            @RequestParam Long id,
            @RequestParam double nouPreu) {

        boolean actualitzat = productService.updateProductPrice(id, nouPreu);
        if (actualitzat) {
            return ResponseEntity.ok("Preu actualitzat correctament.");
        } else {
            return ResponseEntity.status(404).body("Producte no trobat.");
        }
    }
}