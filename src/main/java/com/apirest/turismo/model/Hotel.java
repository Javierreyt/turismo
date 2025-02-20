package com.apirest.turismo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hotel")
public class Hotel {
    @Id
    private String id;
    private String nombre;
    private String direccion;
    private String descripcion;
    private Double calificacion;
}
