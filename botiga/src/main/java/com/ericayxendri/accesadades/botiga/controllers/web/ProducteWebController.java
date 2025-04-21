package com.ericayxendri.accesadades.botiga.controllers.web;

import com.ericayxendri.accesadades.botiga.Dto.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/producte")
public class ProducteWebController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiBaseUrl = "http://localhost:8080/api/botiga/productes";

    @GetMapping
    public String llistarProductes(Model model) {
        ResponseEntity<List<ProductDTO>> resposta = restTemplate.exchange(
            apiBaseUrl + "/getAllProduct",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<ProductDTO>>() {}
        );
        model.addAttribute("products", resposta.getBody());
        return "catalog";
    }

    @GetMapping("/search")
    public String cercarProductes(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            ResponseEntity<List<ProductDTO>> resposta = restTemplate.exchange(
                apiBaseUrl + "/getByNameProduct?name=" + name,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDTO>>() {}
            );
            model.addAttribute("resultats", resposta.getBody());
        }
        return "search";
    }

    @GetMapping("/detall")
    public String veureDetall(@RequestParam Long id, Model model) {
        ResponseEntity<ProductDTO> resposta = restTemplate.getForEntity(
            apiBaseUrl + "/getProduct?idProducte=" + id,
            ProductDTO.class
        );
        model.addAttribute("producte", resposta.getBody());
        return "producte";
    }

    @GetMapping("/formulari")
    public String formulariNouProducte(Model model) {
        model.addAttribute("producteForm", new ProductDTO());
        return "formulariProducte";
    }

    @PostMapping("/formulari")
    public String crearProducte(@ModelAttribute("producteForm") ProductDTO producteForm) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductDTO> request = new HttpEntity<>(producteForm, headers);

        restTemplate.postForEntity(apiBaseUrl + "/postProduct", request, Void.class);
        return "redirect:/producte";
    }
} 
