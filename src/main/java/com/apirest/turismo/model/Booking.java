package com.apirest.turismo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

/**
 * Entidad que representa una reserva (Booking).
 * <p>
 * Contiene información sobre la reserva, como el nombre del huésped,
 * las fechas de entrada y salida, y la referencia al hotel.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
public class Booking {
    /**
     * Identificador único de la reserva.
     */
    @Id
    private String id;

    /**
     * Nombre del huésped.
     */
    private String nombreHuesped;

    /**
     * Fecha de entrada.
     */
    private LocalDate fechaEntrada;

    /**
     * Fecha de salida.
     */
    private LocalDate fechaSalida;

    /**
     * Referencia al hotel (almacenamos el id del hotel).
     */
    private String hotelId;
}
