package com.apirest.turismo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

/**
 * Entidad que representa un Hotel.
 * <p>
 * Contiene información como el nombre, dirección, descripción y calificación del hotel.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hoteles")
public class Hotel {
    /**
     * Identificador único del hotel.
     */
    @Id
    private String id;

    /**
     * Nombre del hotel.
     */
    private String nombre;

    /**
     * Dirección del hotel.
     */
    private String direccion;

    /**
     * Descripción del hotel.
     */
    private String descripcion;

    /**
     * Calificación promedio del hotel.
     */
    private Double calificacion;
}
