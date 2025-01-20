package com.example.booking.service;

import com.example.booking.dto.BookingRequest;
import com.example.booking.model.Booking;
import com.example.booking.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    private BookingRequest bookingRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        bookingRequest = new BookingRequest();
        bookingRequest.setHotelName("Hotel ABC");
        bookingRequest.setGuestName("John Doe");
        bookingRequest.setCheckInDate("2025-01-25");
        bookingRequest.setCheckOutDate("2025-01-30");
    }

    @Test
    void testCreateBooking() {
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setGuestName("John Doe");
        bookingRequest.setCheckInDate(LocalDateTime.now().toString());

        Booking booking = Booking.of(bookingRequest);

        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        UUID bookingId = bookingService.createBooking(bookingRequest);

        assertNotNull(bookingId);

        verify(bookingRepository, times(1)).save(any(Booking.class));
    }


    @Test
    void testCreateBookingWhenRepositoryFails() {
        when(bookingRepository.save(any(Booking.class))).thenReturn(null);

        UUID bookingId = bookingService.createBooking(bookingRequest);

        assertNull(bookingId);

        verify(bookingRepository, times(1)).save(any(Booking.class));
    }

}
