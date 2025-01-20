package com.example.booking.dto;

import com.example.booking.model.Booking;

import java.util.UUID;

public class BookingResponse {
    private UUID id;
    private String hotelName;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;

    public BookingResponse(UUID id, String hotelName, String guestName, String checkInDate, String checkOutDate) {
        this.id = id;
        this.hotelName = hotelName;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public static BookingResponse of(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getHotelName(),
                booking.getGuestName(),
                booking.getCheckInDate(),
                booking.getCheckOutDate()
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
