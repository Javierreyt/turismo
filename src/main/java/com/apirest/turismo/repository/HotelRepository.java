package com.apirest.turismo.repository;

import com.apirest.turismo.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
}
