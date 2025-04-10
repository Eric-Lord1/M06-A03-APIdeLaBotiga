package com.ericayxendri.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String descripcion;
    private String estado;
    private LocalDateTime creado;
    private LocalDateTime actualizado;
}

