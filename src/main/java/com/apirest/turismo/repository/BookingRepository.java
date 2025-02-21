package com.apirest.turismo.repository;

import com.apirest.turismo.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio para gestionar las reservas.
 * <p>
 * Proporciona métodos para realizar operaciones CRUD en las reservas.
 * </p>
 */
public interface BookingRepository extends MongoRepository<Booking, String> {
}
