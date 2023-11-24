package com.shoppingcart.bus.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa una orden en el sistema de carrito de compras.
 * Mapeada a la tabla 'orders' en la base de datos.
 */
@Entity
@Table(name = "orders")
@AllArgsConstructor  // Constructor con todos los campos
@NoArgsConstructor   // Constructor sin campos (vacío)
public class Order {
    
    @JsonProperty
    @Getter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único de la orden, auto-generado.

    @JsonBackReference
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Referencia al usuario que hizo la orden. Evita la recursión en JSON.

    @JsonManagedReference
    @Getter @Setter
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetailList = new ArrayList<>();  // Detalles de la orden.
}
