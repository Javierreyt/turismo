package com.apirest.turismo.repository;

import com.apirest.turismo.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repositorio para gestionar las reseñas.
 * <p>
 * Proporciona métodos para realizar operaciones CRUD en las reseñas.
 * </p>
 */
public interface ReviewRepository extends MongoRepository<Review, String> {
    /**
     * Busca las reseñas asociadas al POI con el identificador proporcionado.
     *
     * @param poiId el identificador del POI
     * @return lista de reseñas del POI
     */
    List<Review> findByPoiId(String poiId);
}
