package com.ericayxendri.accesadades.botiga.controllers.web;

import com.ericayxendri.accesadades.botiga.Dto.CategoriaDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaWebController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiBaseUrl = "http://localhost:8080/api/botiga/categories";

    @GetMapping
    public String llistarCategories(Model model) {
        ResponseEntity<List<CategoriaDTO>> resposta = restTemplate.exchange(
            apiBaseUrl + "/getAllCategoria",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<CategoriaDTO>>() {}
        );
        model.addAttribute("categories", resposta.getBody());
        return "categories";
    }

    @GetMapping("/formulari")
    public String formulariNovaCategoria(Model model) {
        model.addAttribute("categoriaForm", new CategoriaDTO());
        return "formulariCategoria";
    }

    @PostMapping("/formulari")
    public String crearCategoria(@ModelAttribute("categoriaForm") CategoriaDTO categoriaForm) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CategoriaDTO> request = new HttpEntity<>(categoriaForm, headers);

        restTemplate.postForEntity(apiBaseUrl + "/postCategoria", request, Void.class);
        return "redirect:/categoria";
    }
} 
