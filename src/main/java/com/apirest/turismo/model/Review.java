package com.apirest.turismo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

/**
 * Entidad que representa una reseña (Review).
 * <p>
 * Contiene información sobre la reseña, como el autor, comentario, calificación y la referencia al POI.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "review")
public class Review {
    /**
     * Identificador único de la reseña.
     */
    @Id
    private String _id;

    /**
     * Autor de la reseña.
     */
    private String autor;

    /**
     * Comentario de la reseña.
     */
    private String comentario;

    /**
     * Calificación de la reseña.
     */
    private Integer calificacion;

    /**
     * Referencia al POI (almacenamos el id del POI).
     */
    private String poiId;
}
