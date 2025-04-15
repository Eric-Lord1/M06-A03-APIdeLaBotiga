package com.ericayxendri.accesadades.botiga.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericayxendri.accesadades.botiga.DTO.ProductDTO;
import com.ericayxendri.accesadades.botiga.models.Categoria;
import com.ericayxendri.accesadades.botiga.models.Product;
import com.ericayxendri.accesadades.botiga.services.CategoriaService;
import com.ericayxendri.accesadades.botiga.services.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class WebController {
 
    @Autowired
    private ProductService productService;
    private CategoriaService categoriaService;
 
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
 
    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        List<Product> products = productService.findAll();
        List<ProductDTO> productDTOs = products.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        model.addAttribute("products", productDTOs);
        return "catalog";
    }

    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Product product = productService.findByName(name);
            ProductDTO productDTO = convertToDTO(product);
            model.addAttribute("product", productDTO);
        }
        return "search";
    }

    //search by nom
    @GetMapping("/api/botiga/CercaProductes")
    public ResponseEntity<List<ProductDTO>> cercaProductesPerNom(@RequestParam String nom) {
        List<Product> productes = productService.findByNameContaining(nom);
        List<ProductDTO> productDTOs = productes.stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
        return ResponseEntity.ok(productDTOs);
    }

    //modify product price
    @PutMapping("/api/botiga/ModificarPreu")
    public ResponseEntity<String> modificarPreuProducte(@RequestParam Long id, @RequestParam Long nouPreu) {
        boolean updated = productService.updateProductPrice(id, nouPreu);
        if (updated) {
            return ResponseEntity.ok("Preu actualitzat correctament.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producte no trobat.");
        }
    }

    //inserir categoria
    @PostMapping("/api/botiga/inserirCategoria")
    public ResponseEntity<Categoria> inserirCategoria(@RequestBody Categoria categoria) {
        Categoria nova = categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    //eliminar producte per id
    @DeleteMapping("/eliminarProducte/{id}")
    public ResponseEntity<String> eliminarProducte(@PathVariable Long id) {
        productService.deleteById(id);
        return null;
        
    }


    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}

    

