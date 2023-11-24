package com.shoppingcart.bus.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * Representa la autenticación basada en API Key para Spring Security.
 */
public class ApiKeyAuthentication extends AbstractAuthenticationToken {

    private final String apiKey;  // La API Key utilizada para autenticación

    /**
     * Constructor que inicializa la API Key y las autoridades.
     *
     * @param apiKey La API Key usada para autenticación.
     * @param authorities Las autoridades o permisos asociados con la API Key.
     */
    public ApiKeyAuthentication(String apiKey, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.apiKey = apiKey;
        setAuthenticated(true); // Marca esta autenticación como válida
    }

    /**
     * Sobrescribe el método para proporcionar las credenciales de la autenticación.
     *
     * @return null ya que las credenciales no se utilizan en la autenticación de API Key.
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    /**
     * Devuelve el principal de la autenticación, en este caso la API Key.
     *
     * @return La API Key.
     */
    @Override
    public Object getPrincipal() {
        return apiKey;
    }
}
