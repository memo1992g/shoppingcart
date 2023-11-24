package com.shoppingcart.bus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shoppingcart.bus.security.AuthenticationFilter;

/**
 * Clase de configuración para definir la configuración de seguridad de la aplicación.
 * 
 * Utiliza anotaciones de Spring para indicar que es una clase de configuración (@Configuration),
 * habilitar la seguridad web (@EnableWebSecurity) y definir el escaneo de componentes
 * en paquetes específicos (@ComponentScan).
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.shoppingcart.*")
public class ShoppingCartBusConfig {

    /**
     * Define la cadena de filtros de seguridad personalizados para HTTP.
     *
     * @param http el constructor de seguridad HTTP proporcionado por Spring Security
     * @return la cadena de filtros de seguridad HTTP construida.
     * @throws Exception si ocurre un error en la configuración
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Personaliza la configuración de seguridad HTTP
        http.csrf()
          .disable() // Deshabilita la protección CSRF para servicios sin estado
          .authorizeRequests()
          .antMatchers("/**") // Asegura todas las rutas
          .authenticated() // Requiere autenticación
          .and()
          .httpBasic() // Permite autenticación básica HTTP
          .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Configura la aplicación como sin estado
          .and()
          .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // Agrega un filtro de autenticación personalizado

        return http.build(); // Construye y devuelve la cadena de filtros de seguridad
    }
}
