package com.example.booking.models;

import java.util.UUID;
import java.time.LocalDateTime;

public class Booking {
    private UUID bookingId;
    private String userId; // Unikalny identyfikator użytkownika
    private String hotelName;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private LocalDateTime createdAt;

    public Booking(String userId, String hotelName, LocalDateTime checkInDate, LocalDateTime checkOutDate) {
        this.bookingId = UUID.randomUUID();
        this.userId = userId;
        this.hotelName = hotelName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
