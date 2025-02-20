package com.apirest.turismo.controller;

import com.apirest.turismo.model.Review;
import com.apirest.turismo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    // GET /reviews - Listar todas las reseñas
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // GET /reviews/{id} - Obtener detalles de una reseña por ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable String id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /reviews - Crear una nueva reseña (protegido)
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewRepository.save(review);
        return ResponseEntity.ok(savedReview);
    }

    // PUT /reviews/{id} - Actualizar una reseña existente (protegido)
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String id, @RequestBody Review reviewDetails) {
        return reviewRepository.findById(id)
                .map(existingReview -> {
                    existingReview.setAutor(reviewDetails.getAutor());
                    existingReview.setComentario(reviewDetails.getComentario());
                    existingReview.setCalificacion(reviewDetails.getCalificacion());
                    // Si es necesario, también se puede actualizar el poiId
                    existingReview.setPoiId(reviewDetails.getPoiId());
                    Review updatedReview = reviewRepository.save(existingReview);
                    return ResponseEntity.ok(updatedReview);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /reviews/{id} - Eliminar una reseña (protegido)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable String id) {
        return reviewRepository.findById(id)
                .map(review -> {
                    reviewRepository.delete(review);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
