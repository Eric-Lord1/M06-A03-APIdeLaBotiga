package com.ericayxendri.accesadades.botiga.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericayxendri.accesadades.botiga.DTO.ProductDTO;
import com.ericayxendri.accesadades.botiga.models.Product;
import com.ericayxendri.accesadades.botiga.services.ProductService;

@Controller
public class WebController {
 
    @Autowired
    private ProductService productService;
 
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
 
    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        List products = (List) productService.findAllProducts();
        model.addAttribute("products", products);
        return "catalog";
    }

    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Product product = productService.findProductsByName(name);
            model.addAttribute("product", product);
        }
        return "search";
    }

    /* @GetMapping("/LlistarProductes")
    public List<ProductDTO> llistarProductes() {
        List<Product> productes = productService.LlistarProductes(); 
        return Mapper.toProductDTOList(productes); 
    } */
}

    

