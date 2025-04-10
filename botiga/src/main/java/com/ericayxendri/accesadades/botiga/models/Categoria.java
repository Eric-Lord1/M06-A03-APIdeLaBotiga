package com.ericayxendri.accesadades.botiga.models;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Categoria;

    @Column
    private String name;

    @Column
    private String status_Categoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Subcategoria> subcategorias;

    @Column
    private LocalDateTime creation_at;

    @Column
    private LocalDateTime updated_at;
}
