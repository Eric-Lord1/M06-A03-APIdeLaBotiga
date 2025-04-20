package com.ericayxendri.accesadades.botiga.mapper;

import com.ericayxendri.accesadades.botiga.Dto.CategoriaDTO;
import com.ericayxendri.accesadades.botiga.Dto.ProductDTO;
import com.ericayxendri.accesadades.botiga.Dto.SubcategoriaDTO;
import com.ericayxendri.accesadades.botiga.models.Categoria;
import com.ericayxendri.accesadades.botiga.models.Product;
import com.ericayxendri.accesadades.botiga.models.Subcategoria;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BotigaMapper {

    CategoriaDTO toCategoriaDTO(Categoria categoria);

    @Mapping(target = "creation_at", ignore = true)
    @Mapping(target = "id_Categoria", ignore = true)
    @Mapping(target = "subcategorias", ignore = true)
    @Mapping(target = "updated_at", ignore = true)
    Categoria toCategoria(CategoriaDTO categoriaDTO);

    SubcategoriaDTO toSubcategoriaDTO(Subcategoria subcategoria);

    @Mapping(target = "categoria", ignore = true)
    @Mapping(target = "creation_at", ignore = true)
    @Mapping(target = "id_Subcategoria", ignore = true)
    @Mapping(target = "updated_at", ignore = true)
    Subcategoria toSubcategoria(SubcategoriaDTO subcategoriaDTO);


    ProductDTO toProducteDTO(Product producte);

    @Mapping(target = "product_id", ignore = true)
    @Mapping(target = "subcategoria", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    Product toProducte(ProductDTO producteDTO);

}