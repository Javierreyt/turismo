package com.apirest.turismo.controller;

import com.apirest.turismo.model.Review;
import com.apirest.turismo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar las reseñas.
 * <p>
 * Proporciona endpoints para crear, actualizar, listar y obtener detalles de reseñas.
 * </p>
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Listar todas las reseñas.
     *
     * @return Lista de todas las reseñas
     */
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    /**
     * Obtener detalles de una reseña por ID.
     *
     * @param id Identificador de la reseña
     * @return ResponseEntity con los detalles de la reseña o un mensaje de error
     */
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable String id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crear una nueva reseña.
     *
     * @param review Información de la reseña a crear
     * @return ResponseEntity con la reseña creada
     */
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewRepository.save(review);
        return ResponseEntity.ok(savedReview);
    }

    /**
     * Actualizar una reseña existente.
     *
     * @param id Identificador de la reseña a actualizar
     * @param reviewDetails Información de la reseña actualizada
     * @return ResponseEntity con la reseña actualizada o un mensaje de error
     */
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

    /**
     * Eliminar una reseña.
     *
     * @param id Identificador de la reseña a eliminar
     * @return ResponseEntity con un mensaje de éxito o error
     */
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