package com.apirest.turismo.controller;


import com.apirest.turismo.model.Hotel;
import com.apirest.turismo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar los hoteles (\Hotel\).
 * <p>
 * Proporciona endpoints para crear, actualizar, listar y obtener detalles de hoteles.
 * </p>
 */
@RestController
@RequestMapping("/hoteles")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Listar todos los hoteles.
     *
     * @return Lista de todos los hoteles
     */
    @GetMapping
    public List<Hotel> getAllHoteles() {
        return hotelRepository.findAll();
    }

    /**
     * Obtener detalles de un hotel por ID.
     *
     * @param id Identificador del hotel
     * @return ResponseEntity con los detalles del hotel o un mensaje de error
     */
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crear un nuevo hotel.
     *
     * @param hotel Información del hotel a crear
     * @return ResponseEntity con el hotel creado
     */
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelRepository.save(hotel);
        return ResponseEntity.ok(savedHotel);
    }

    /**
     * Actualizar información de un hotel existente.
     *
     * @param id Identificador del hotel a actualizar
     * @param hotelDetails Detalles actualizados del hotel
     * @return ResponseEntity con el hotel actualizado o un mensaje de error
     */
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
