package com.shoppingcart.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

/**
 * Clase principal de la aplicación Spring Boot para el backend de un carrito de compras.
 * 
 * @SpringBootApplication es una anotación de conveniencia que agrega:
 * - @Configuration: Marca la clase como una fuente de definiciones de beans para el contexto de la aplicación.
 * - @EnableAutoConfiguration: Le dice a Spring Boot que inicie la configuración automática basada en el contenido del classpath.
 * - @ComponentScan: Le dice a Spring que busque otros componentes, configuraciones y servicios en el paquete actual,
 * permitiendo que se descubran e inyecten las clases decoradas con @Component, @Service, etc.
 * 
 * Las configuraciones automáticas relacionadas con la seguridad están explícitamente excluidas, lo que significa que la aplicación no
 * aplicará configuraciones de seguridad por defecto y permite una configuración de seguridad personalizada.
 */
@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class, 
		UserDetailsServiceAutoConfiguration.class})
public class ShoppingcartBusApplication {

	/**
	 * El punto de entrada principal de la aplicación.
	 * 
	 * @param args Los argumentos de la línea de comandos pasados durante el inicio de la aplicación.
	 */
	public static void main(String[] args) {
		// Inicia la aplicación Spring Boot, lo que a su vez arranca el contenedor de servlet embebido,
		// configura la aplicación y la deja lista para atender peticiones.
		SpringApplication.run(ShoppingcartBusApplication.class, args);
	}
}
