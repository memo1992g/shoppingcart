package com.shoppingcart.bus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase de Data Transfer Object (DTO) para productos.
 * Utiliza anotaciones de Lombok para reducir el boilerplate de código Java.
 * Incluye anotaciones de Jackson para la serialización y deserialización JSON.
 */
@NoArgsConstructor  // Crea un constructor sin argumentos
@AllArgsConstructor // Crea un constructor con todos los argumentos
@Builder            // Permite construir objetos con el patrón de diseño builder
public class ProductDto {
    
    @Getter @Setter
    @JsonProperty
    private Long id;  // Identificador único del producto

    @Getter @Setter
    @JsonProperty
    private String title;  // Título o nombre del producto

    @Getter @Setter
    @JsonProperty
    private Double price;  // Precio del producto

    @Getter @Setter
    @JsonProperty
    private String description;  // Descripción del producto

    @Getter @Setter
    @JsonProperty
    private String category;  // Categoría del producto (corregido de 'categtory')

    @Getter @Setter
    @JsonProperty
    private String image;  // URL de la imagen del producto
}
