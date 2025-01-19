package com.example.booking.services;

import com.example.booking.models.Booking;
import com.example.booking.repositories.BookingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookingService {
    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(String userId, String hotelName, LocalDateTime checkIn, LocalDateTime checkOut) {
        if (checkIn.isAfter(checkOut)) {
            throw new IllegalArgumentException("Data zameldowania musi być przed datą wymeldowania.");
        }
        Booking booking = new Booking(userId, hotelName, checkIn, checkOut);
        return repository.save(booking);
    }

    public List<Booking> getUserBookings(String userId) {
        return repository.findByUserId(userId);
    }

    public boolean cancelBooking(UUID bookingId) {
        return repository.delete(bookingId);
    }
}
