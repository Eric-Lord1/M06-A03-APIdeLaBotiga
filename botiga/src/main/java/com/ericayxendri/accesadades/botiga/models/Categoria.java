package com.ericayxendri.accesadades.botiga.models;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Categoria;

    @Column
    private String desc_Categoria;

    @Column
    private String status_Categoria;

    @Column
    private Subcategoria subcategoria;

    @Column
    private LocalDateTime creation_at;

    @Column
    private LocalDateTime updated_at;
}
