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

@RestController
@RequestMapping("/pois")
public class POIController {

    @Autowired
    private POIRepository poiRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    // GET /pois - Listar todos los puntos de interés
    @GetMapping
    public List<POI> getAllPOIs() {
        return poiRepository.findAll();
    }

    // GET /pois/{id} - Obtener detalles de un POI
    @GetMapping("/{id}")
    public ResponseEntity<POI> getPOIById(@PathVariable String id) {
        Optional<POI> poi = poiRepository.findById(id);
        return poi.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /pois - Crear un nuevo POI (protegido)
    @PostMapping
    public ResponseEntity<POI> createPOI(@RequestBody POI poi) {
        POI savedPOI = poiRepository.save(poi);
        return ResponseEntity.ok(savedPOI);
    }

    // GET /pois/categorias - Listar categorías únicas de POIs
    @GetMapping("/categorias")
    public List<String> getCategorias() {
        return poiRepository.findAll().stream()
                .map(POI::getCategoria)
                .distinct()
                .toList();
    }
    // POST /pois/{id}/reviews - Añadir una reseña a un POI (protegido)
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
