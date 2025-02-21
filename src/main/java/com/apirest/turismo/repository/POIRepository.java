package com.apirest.turismo.repository;

import com.apirest.turismo.model.POI;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Repositorio para gestionar los puntos de interés (POI).
 * <p>
 * Proporciona métodos para realizar operaciones CRUD en los POI.
 * </p>
 */
public interface POIRepository extends MongoRepository<POI, String> {
    /**
     * Busca los POIs que pertenezcan a la categoría especificada.
     *
     * @param categoria la categoría del POI
     * @return lista de POIs que coinciden con la categoría
     */
    List<POI> findByCategoria(String categoria);
}
