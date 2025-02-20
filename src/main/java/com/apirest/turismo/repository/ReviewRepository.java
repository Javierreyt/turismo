package com.apirest.turismo.repository;

import com.apirest.turismo.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByPoiId(String poiId);
}
