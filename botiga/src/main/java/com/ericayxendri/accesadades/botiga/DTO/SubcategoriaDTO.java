package com.ericayxendri.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubcategoriaDTO {
    private Long id;
    private String descripcion;
    private String estado;
    private LocalDateTime creado;
    private LocalDateTime actualizado;
    private Long categoriaId;
}

