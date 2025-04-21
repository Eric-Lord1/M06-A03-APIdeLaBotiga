package com.ericayxendri.accesadades.botiga.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubcategoriaDTO {

    private String name;

    private String status;

    private CategoriaDTO categoria;

}

