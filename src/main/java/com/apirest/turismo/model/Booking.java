package com.apirest.turismo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
public class Booking {
    @Id
    private String id;
    private String nombreHuesped;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    // Referencia al hotel (almacenamos el id del hotel)
    private String hotelId;
}
