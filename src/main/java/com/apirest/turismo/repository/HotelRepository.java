package com.apirest.turismo.repository;

import com.apirest.turismo.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio para gestionar los hoteles.
 * <p>
 * Proporciona métodos para realizar operaciones CRUD en los hoteles.
 * </p>
 */
public interface HotelRepository extends MongoRepository<Hotel, String> {
}
