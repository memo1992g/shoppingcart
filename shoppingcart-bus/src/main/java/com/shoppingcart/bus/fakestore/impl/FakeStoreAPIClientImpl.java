package com.shoppingcart.bus.fakestore.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shoppingcart.bus.dto.ProductDto;
import com.shoppingcart.bus.fakestore.FakeStoreAPIClient;

/**
 * Implementación de la interfaz FakeStoreAPIClient.
 * Proporciona métodos para realizar llamadas a la API de Fake Store.
 */
@Component
public class FakeStoreAPIClientImpl implements FakeStoreAPIClient {
    
    private final String apiUrl = "https://fakestoreapi.com";  // URL base de la API de Fake Store

    /**
     * Obtiene una lista de productos desde la API de Fake Store.
     * 
     * @return ResponseEntity con una lista de ProductDto o un estado NOT_FOUND si falla.
     */
    @Override
    public ResponseEntity<List<ProductDto>> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            // Realiza la llamada GET a la API y obtiene la respuesta
            ResponseEntity<List<ProductDto>> responseEntity =
                    restTemplate.exchange(
                            apiUrl + "/products",
                            HttpMethod.GET, 
                            null, 
                            new ParameterizedTypeReference<List<ProductDto>>() {});

            return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Obtiene un producto específico por ID desde la API de Fake Store.
     * 
     * @param productId El ID del producto a obtener.
     * @return ResponseEntity con ProductDto o un estado NOT_FOUND si falla.
     */
    @Override
    public ResponseEntity<ProductDto> getProduct(Long productId) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            // Realiza la llamada GET a la API y obtiene la respuesta
            ResponseEntity<ProductDto> responseEntity =
                    restTemplate.exchange(
                            apiUrl + "/products/" + productId,
                            HttpMethod.GET, 
                            null, 
                            new ParameterizedTypeReference<ProductDto>() {});

            return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
