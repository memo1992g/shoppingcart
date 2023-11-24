package com.shoppingcart.bus.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * Filtro de autenticación personalizado para la aplicación web.
 */
public class AuthenticationFilter extends GenericFilterBean {

    /**
     * Procesa cada solicitud HTTP pasándola por el filtro de autenticación.
     *
     * @param request La solicitud entrante.
     * @param response La respuesta a enviar.
     * @param filterChain La cadena de filtros de la aplicación.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            // Obtiene la autenticación basada en la solicitud actual
            Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) request);
            
            // Establece la autenticación en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception exp) {
            // Maneja excepciones y envía una respuesta de error
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            PrintWriter writer = httpResponse.getWriter();
            writer.print(exp.getMessage());
            writer.flush();
            writer.close();
            return;
        }

        // Continúa con el resto de la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
