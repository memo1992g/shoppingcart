package com.shoppingcart.bus.fakestore;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.shoppingcart.bus.dto.ProductDto;

/**
 * Interfaz para el cliente de API de Fake Store.
 * Define los métodos para interactuar con un servicio externo de API de productos.
 */
public interface FakeStoreAPIClient {

    /**
     * Obtiene una lista de productos.
     * 
     * @return ResponseEntity que encapsula una lista de ProductDto.
     */
    ResponseEntity<List<ProductDto>> getProducts();

    /**
     * Obtiene un producto específico por su identificador.
     * 
     * @param productId El identificador del producto.
     * @return ResponseEntity que encapsula el ProductDto del producto solicitado.
     */
    ResponseEntity<ProductDto> getProduct(Long productId);
}
