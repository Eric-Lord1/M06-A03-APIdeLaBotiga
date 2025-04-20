package com.ericayxendri.accesadades.botiga.controllers.web;

import com.ericayxendri.accesadades.botiga.Dto.SubcategoriaDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/subcategoria")
public class SubcategoriaWebController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiBaseUrl = "http://localhost:8080/api/botiga/subcategories";

    @GetMapping
    public String llistarSubcategories(Model model) {
        ResponseEntity<List<SubcategoriaDTO>> resposta = restTemplate.exchange(
            apiBaseUrl + "/getAllSubcategoria",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<SubcategoriaDTO>>() {}
        );
        model.addAttribute("subcategories", resposta.getBody());
        return "subcategories";
    }

    @GetMapping("/formulari")
    public String formulariNovaSubcategoria(Model model) {
        model.addAttribute("subcategoriaForm", new SubcategoriaDTO());
        return "formulariSubcategoria";
    }

    @PostMapping("/formulari")
    public String crearSubcategoria(@ModelAttribute("subcategoriaForm") SubcategoriaDTO subcategoriaForm) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SubcategoriaDTO> request = new HttpEntity<>(subcategoriaForm, headers);

        restTemplate.postForEntity(apiBaseUrl + "/postSubcategoria", request, Void.class);
        return "redirect:/subcategoria";
    }
} 