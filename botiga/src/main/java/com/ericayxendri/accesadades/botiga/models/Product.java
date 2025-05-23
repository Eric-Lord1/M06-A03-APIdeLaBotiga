package com.ericayxendri.accesadades.botiga.models;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String company;

    @Column
    private double price;

    @Column
    private long units;

    @Column(name = "creation_at")
    private LocalDateTime creationDate;

    @Column(name = "updated_at")
    private LocalDateTime updateDate;
    
    @ManyToOne
    @JoinColumn(name = "subcategoria_id")
    private Subcategoria subcategoria;

}
