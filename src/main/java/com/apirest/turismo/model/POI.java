package com.apirest.turismo.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

/**
 * Entidad que representa un Punto de Interés (POI).
 * <p>
 * Contiene información sobre el punto de interés, como el nombre,
 * descripción, latitud, longitud y categoría.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "POI")
public class POI {
    /**
     * Identificador único del POI.
     */
    @Id
    private String _id;

    /**
     * Nombre del POI.
     */
    private String nombre;

    /**
     * Descripción del POI.
     */
    private String descripcion;

    /**
     * Latitud del POI.
     */
    private Double latitud;

    /**
     * Longitud del POI.
     */
    private Double longitud;

    /**
     * Categoría del POI.
     */
    private String categoria;
}
