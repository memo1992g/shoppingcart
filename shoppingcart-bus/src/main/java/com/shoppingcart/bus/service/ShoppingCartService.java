package com.shoppingcart.bus.service;

import org.springframework.http.ResponseEntity;
import com.shoppingcart.bus.entity.Order;

/**
 * Interfaz de servicio para operaciones del carrito de compras.
 */
public interface ShoppingCartService {

    /**
     * Crea una nueva orden para un usuario.
     *
     * @param userId El ID del usuario para el cual se crea la orden.
     * @return ResponseEntity conteniendo la Orden creada.
     */
    ResponseEntity<Order> createOrder(Long userId);

    /**
     * Agrega un producto a una orden existente.
     *
     * @param orderId El ID de la orden a la cual se agrega el producto.
     * @param productId El ID del producto que se agrega.
     * @param quantity La cantidad del producto que se agrega.
     * @return ResponseEntity conteniendo la Orden actualizada.
     */
    ResponseEntity<Order> addProduct(Long orderId, Long productId, Integer quantity);
}
