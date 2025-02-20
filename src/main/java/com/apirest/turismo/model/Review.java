package com.apirest.turismo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "review")
public class Review {
    @Id
    private String id;
    private String autor;
    private String comentario;
    private Integer calificacion;
    // Referencia al POI (almacenamos el id del POI)
    private String poiId;
}
