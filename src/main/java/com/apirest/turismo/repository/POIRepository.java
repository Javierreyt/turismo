package com.apirest.turismo.repository;

import com.apirest.turismo.model.POI;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface POIRepository extends MongoRepository<POI, String> {
    List<POI> findByCategoria(String categoria);
}
