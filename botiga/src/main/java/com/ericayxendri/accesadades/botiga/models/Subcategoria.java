package com.ericayxendri.accesadades.botiga.models;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Subcategoria")
public class Subcategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Subcategoria;

    @Column
    private String desc_Subcategoria;

    @Column
    private String status_Categoria;

    @Column 
    private Categoria categoria;

    @Column
    private LocalDateTime creation_at;

    @Column 
    private LocalDateTime updated_at;
}
