package com.ericayxendri.accesadades.botiga.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;

    private String description;

    private String company;

    private Double price;

    private Long units;

    private SubcategoriaDTO subcategoria;

}
