package com.example.booking.repositories;

import com.example.booking.models.Booking;

import java.util.*;
import java.util.stream.Collectors;

public class BookingRepository {
    private final Map<UUID, Booking> bookings = new HashMap<>();

    public Booking save(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }

    public List<Booking> findByUserId(String userId) {
        return bookings.values()
                .stream()
                .filter(booking -> booking.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public Optional<Booking> findById(UUID bookingId) {
        return Optional.ofNullable(bookings.get(bookingId));
    }

    public boolean delete(UUID bookingId) {
        return bookings.remove(bookingId) != null;
    }
}

