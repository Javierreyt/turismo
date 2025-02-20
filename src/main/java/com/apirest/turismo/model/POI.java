package com.apirest.turismo.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "POI")
public class POI {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Double latitud;
    private Double longitud;
    private String categoria;
}
