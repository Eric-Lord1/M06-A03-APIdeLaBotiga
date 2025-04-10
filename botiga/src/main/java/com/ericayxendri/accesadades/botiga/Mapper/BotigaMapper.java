package com.ericayxendri.accesadades.botiga.Mapper;

import com.ericayxendri.accesadades.botiga.DTO.CategoriaDTO;
import com.ericayxendri.accesadades.botiga.DTO.ProductDTO;
import com.ericayxendri.accesadades.botiga.DTO.SubcategoriaDTO;
import com.ericayxendri.accesadades.botiga.models.Categoria;
import com.ericayxendri.accesadades.botiga.models.Product;
import com.ericayxendri.accesadades.botiga.models.Subcategoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BotigaMapper {

    @Mapping(source = "id_Categoria", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "status_Categoria", target = "estado")
    @Mapping(source = "creation_at", target = "creado")
    @Mapping(source = "updated_at", target = "actualizado")

    CategoriaDTO toCategoriaDTO(Categoria categoria);

    @Mapping(source = "id", target = "id_Categoria")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "estado", target = "status_Categoria")
    @Mapping(source = "creado", target = "creation_at")
    @Mapping(source = "actualizado", target = "updated_at")
    Categoria toCategoria(CategoriaDTO categoriaDTO);

    @Mapping(source = "id_Subcategoria", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "status_Categoria", target = "estado")
    @Mapping(source = "creation_at", target = "creado")
    @Mapping(source = "updated_at", target = "actualizado")
    @Mapping(source = "categoria.id_Categoria", target = "categoriaId")
    SubcategoriaDTO toSubcategoriaDTO(Subcategoria subcategoria);

    @Mapping(source = "id", target = "id_Subcategoria")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "estado", target = "status_Categoria")
    @Mapping(source = "creado", target = "creation_at")
    @Mapping(source = "actualizado", target = "updated_at")
    @Mapping(target = "categoria", ignore = true)
    Subcategoria toSubcategoria(SubcategoriaDTO subcategoriaDTO);

    ProductDTO toProducteDTO(Product producte);

    Product toProducte(ProductDTO producteDTO);
}
