package com.apirest.turismo.controller;

import com.apirest.turismo.model.POI;
import com.apirest.turismo.model.Review;
import com.apirest.turismo.repository.POIRepository;
import com.apirest.turismo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar los puntos de interés (POI).
 * <p>
 * Proporciona endpoints para crear, actualizar, listar y obtener detalles de puntos de interés.
 * </p>
 */
@RestController
@RequestMapping("/pois")
public class POIController {

    @Autowired
    private POIRepository poiRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Listar todos los puntos de interés.
     *
     * @return Lista de todos los puntos de interés
     */
    @GetMapping
    public List<POI> getAllPOIs() {
        return poiRepository.findAll();
    }

    /**
     * Obtener detalles de un punto de interés por ID.
     *
     * @param id Identificador del punto de interés
     * @return ResponseEntity con los detalles del punto de interés o un mensaje de error
     */
    @GetMapping("/{id}")
    public ResponseEntity<POI> getPOIById(@PathVariable String id) {
        Optional<POI> poi = poiRepository.findById(id);
        return poi.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crear un nuevo punto de interés.
     *
     * @param poi Información del punto de interés a crear
     * @return ResponseEntity con el punto de interés creado
     */
    @PostMapping
    public ResponseEntity<POI> createPOI(@RequestBody POI poi) {
        POI savedPOI = poiRepository.save(poi);
        return ResponseEntity.ok(savedPOI);
    }

    /**
     * Listar categorías únicas de puntos de interés.
     *
     * @return Lista de categorías únicas
     */
    @GetMapping("/categorias")
    public List<String> getCategorias() {
        return poiRepository.findAll().stream()
                .map(POI::getCategoria)
                .distinct()
                .toList();
    }

    /**
     * Añadir una reseña a un punto de interés.
     *
     * @param id Identificador del punto de interés
     * @param review Información de la reseña a añadir
     * @return ResponseEntity con la reseña añadida o un mensaje de error
     */
    @PostMapping("/{id}/reviews")
    public ResponseEntity<?> addReview(@PathVariable String id, @RequestBody Review review) {
        Optional<POI> poi = poiRepository.findById(id);
        if (poi.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        review.setPoiId(id);
        Review savedReview = reviewRepository.save(review);
        return ResponseEntity.ok(savedReview);
    }
}
