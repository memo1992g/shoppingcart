package com.shoppingcart.bus.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingcart.bus.dto.ProductDto;
import com.shoppingcart.bus.entity.Order;
import com.shoppingcart.bus.entity.OrderDetail;
import com.shoppingcart.bus.entity.User;
import com.shoppingcart.bus.fakestore.FakeStoreAPIClient;
import com.shoppingcart.bus.repository.OrderDetailRP;
import com.shoppingcart.bus.repository.OrderRP;
import com.shoppingcart.bus.repository.UserRP;
import com.shoppingcart.bus.service.ShoppingCartService;

/**
 * Implementación del servicio de carrito de compras.
 * Provee métodos para crear órdenes y agregar productos a órdenes existentes.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    
    @Autowired
    private UserRP userRP;  // Repositorio de usuarios
    
    @Autowired
    private OrderRP orderRP;  // Repositorio de órdenes
    
    @Autowired
    private OrderDetailRP orderDetailRP;  // Repositorio de detalles de órdenes
    
    @Autowired
    private FakeStoreAPIClient fakeStoreAPIClient;  // Cliente para la API de Fake Store

    /**
     * Crea una nueva orden para un usuario.
     *
     * @param userId El ID del usuario.
     * @return ResponseEntity con la orden creada o un error.
     */
    @Override
    public ResponseEntity<Order> createOrder(Long userId) {
        try {
            Optional<User> user = userRP.findById(userId);
            if (user.isPresent()) {
                Order order = new Order();
                order.setUser(user.get());
                Order newOrder = orderRP.save(order);
                return new ResponseEntity<>(newOrder, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Agrega un producto a una orden existente.
     *
     * @param orderId El ID de la orden.
     * @param productId El ID del producto.
     * @param quantity La cantidad del producto.
     * @return ResponseEntity con la orden actualizada o un error.
     */
    @Override
    public ResponseEntity<Order> addProduct(Long orderId, Long productId, Integer quantity) {
        try {
            Optional<Order> order = orderRP.findById(orderId);
            if (order.isPresent()) {
                ProductDto product = fakeStoreAPIClient.getProduct(productId).getBody();
                OrderDetail detail = new OrderDetail();
                detail.setOrder(order.get());
                detail.setProductId(product.getId());
                detail.setPrice(product.getPrice());
                detail.setQuantity(quantity);
                orderDetailRP.save(detail);
                return new ResponseEntity<>(order.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
