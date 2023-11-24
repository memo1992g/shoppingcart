package com.shoppingcart.bus.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import com.shoppingcart.bus.repository.UserRP;

/**
 * Servicio para manejar la autenticación basada en API key.
 */
public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    private static final String AUTH_TOKEN = "ShoppingCart";
    
    @Autowired
    private UserRP userRP;

    /**
     * Autentica una solicitud HTTP basada en una API key.
     *
     * @param request La solicitud HTTP entrante.
     * @return Una instancia de Authentication si la API key es válida.
     */
    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        
        // Verifica si la API key es válida
        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }
        
        // Retorna una autenticación válida si la API key es correcta
        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
