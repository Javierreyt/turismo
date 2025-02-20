package com.apirest.turismo.controller;


import com.apirest.turismo.model.Booking;
import com.apirest.turismo.model.Hotel;
import com.apirest.turismo.repository.BookingRepository;
import com.apirest.turismo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // POST /bookings - Crear una booking en un hotel (protegido)
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        if (booking.getHotelId() == null || booking.getHotelId().isEmpty()) {
            return ResponseEntity.badRequest().body("Falta la información del hotel.");
        }
        Optional<Hotel> hotel = hotelRepository.findById(booking.getHotelId());
        if (hotel.isEmpty()) {
            return ResponseEntity.badRequest().body("Hotel no encontrado.");
        }
        Booking savedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(savedBooking);
    }
}
