package com.shoppingcart.bus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.bus.entity.User;

/**
 * Repositorio JPA para la entidad User.
 * Extiende CrudRepository para proporcionar operaciones CRUD básicas para la entidad User.
 */
@Repository
public interface UserRP extends CrudRepository<User, Long> {

    /**
     * Consulta personalizada para obtener un usuario por su token.
     * 
     * @param token Token del usuario.
     * @return User correspondiente al token proporcionado.
     */
    @Query("from User user where user.token = :token")
    public User getUserByToken(String token);
}
