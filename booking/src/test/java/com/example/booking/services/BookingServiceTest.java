package com.example.booking.services;

import com.example.booking.models.Booking;
import com.example.booking.repositories.BookingRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {
    @Test
    public void testCreateBooking() {
        BookingRepository repo = new BookingRepository();
        BookingService service = new BookingService(repo);

        Booking booking = service.createBooking(
                "user1", "Hotel ABC",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2)
        );

        assertNotNull(booking.getBookingId());
        assertEquals("user1", booking.getUserId());
        assertEquals("Hotel ABC", booking.getHotelName());
    }

    @Test
    public void testCancelBooking() {
        BookingRepository repo = new BookingRepository();
        BookingService service = new BookingService(repo);

        Booking booking = service.createBooking(
                "user1", "Hotel ABC",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2)
        );

        assertTrue(service.cancelBooking(booking.getBookingId()));
        assertFalse(repo.findById(booking.getBookingId()).isPresent());
    }
}
