package com.ericayxendri.accesadades.botiga.Mapper;

import com.ericayxendri.accesadades.botiga.DTO.CategoriaDTO;
import com.ericayxendri.accesadades.botiga.DTO.ProductDTO;
import com.ericayxendri.accesadades.botiga.DTO.SubcategoriaDTO;
import com.ericayxendri.accesadades.botiga.models.Categoria;
import com.ericayxendri.accesadades.botiga.models.Product;
import com.ericayxendri.accesadades.botiga.models.Subcategoria;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring") 
public interface BotigaMapper {

    CategoriaDTO toCategoriaDTO(Categoria categoria); 
    Categoria toCategoria(CategoriaDTO categoriaDTO); 

    SubcategoriaDTO toSubcategoriaDTO(Subcategoria subcategoria);
    Subcategoria toSubcategoria(SubcategoriaDTO subcategoriaDTO);

    ProductDTO toProducteDTO(Product producte);
    Product toProducte(ProductDTO producteDTO);
}

