package com.apirest.turismo.controller;


import com.apirest.turismo.model.Hotel;
import com.apirest.turismo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    // GET /hoteles - Listar todos los hoteles
    @GetMapping
    public List<Hotel> getAllHoteles() {
        return hotelRepository.findAll();
    }

    // GET /hoteles/{id} - Obtener detalles de un hotel
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /hoteles - Crear un nuevo hotel (protegido)
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelRepository.save(hotel);
        return ResponseEntity.ok(savedHotel);
    }

    // PUT /hoteles/{id} - Actualizar información de un hotel (protegido)
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody Hotel hotelDetails) {
        return hotelRepository.findById(id)
                .map(hotel -> {
                    hotel.setNombre(hotelDetails.getNombre());
                    hotel.setDireccion(hotelDetails.getDireccion());
                    hotel.setDescripcion(hotelDetails.getDescripcion());
                    hotel.setCalificacion(hotelDetails.getCalificacion());
                    Hotel updatedHotel = hotelRepository.save(hotel);
                    return ResponseEntity.ok(updatedHotel);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
