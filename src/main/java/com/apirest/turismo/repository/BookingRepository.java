package com.apirest.turismo.repository;

import com.apirest.turismo.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
