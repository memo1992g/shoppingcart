package com.shoppingcart.svc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.bus.dto.ProductDto;
import com.shoppingcart.bus.fakestore.FakeStoreAPIClient;

/**
 * Controlador REST para manejar las operaciones relacionadas con los productos.
 */
@RestController
@RequestMapping("products")  // Define la ruta base para este controlador
public class ProductController {

    @Autowired
    private FakeStoreAPIClient fakeStoreAPIClient;  // Cliente de API para obtener información de productos

    /**
     * Obtiene una lista de todos los productos.
     *
     * @return ResponseEntity con una lista de ProductDto.
     */
    @GetMapping("")
    ResponseEntity<List<ProductDto>> getProducts() {
        return this.fakeStoreAPIClient.getProducts();
    }
    
    /**
     * Obtiene un producto específico por su ID.
     *
     * @param productId El ID del producto.
     * @return ResponseEntity con el ProductDto del producto solicitado.
     */
    @GetMapping("/{productId}")
    ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        return this.fakeStoreAPIClient.getProduct(productId);
    }
}
