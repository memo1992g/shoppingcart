package com.shoppingcart.svc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.bus.entity.Order;
import com.shoppingcart.bus.service.ShoppingCartService;

/**
 * Controlador REST para manejar las operaciones relacionadas con las órdenes en el carrito de compras.
 */
@RestController
@RequestMapping("orders")  // Base URL para todas las operaciones en este controlador
public class OrderController {

    @Autowired
    private ShoppingCartService shoppingCartService;  // Servicio de carrito de compras inyectado

    /**
     * Crea una nueva orden para el usuario especificado.
     *
     * @param userId El ID del usuario.
     * @return ResponseEntity que contiene la orden creada.
     */
    @PostMapping("/new/{userId}")
    ResponseEntity<Order> createOrder(@PathVariable Long userId) {
        return this.shoppingCartService.createOrder(userId);
    }
    
    /**
     * Agrega un producto a una orden existente.
     *
     * @param orderId El ID de la orden.
     * @param productId El ID del producto a agregar.
     * @param quantity La cantidad del producto a agregar.
     * @return ResponseEntity que contiene la orden actualizada.
     */
    @PostMapping("/{orderId}")
    ResponseEntity<Order> addProduct(
            @PathVariable Long orderId, 
            @RequestParam Long productId,
            @RequestParam Integer quantity) {
        return this.shoppingCartService.addProduct(orderId, productId, quantity);
    }
}
