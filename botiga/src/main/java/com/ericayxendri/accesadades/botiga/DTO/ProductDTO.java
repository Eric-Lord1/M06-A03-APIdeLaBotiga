package com.ericayxendri.accesadades.botiga.DTO;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String company;
    private Float price;
    private Long units;
    private LocalDate creationDate;
    private LocalDate updateDate;
    private String subcategory;
}
