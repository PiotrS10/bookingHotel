package com.example.booking.model;

import com.example.booking.dto.BookingRequest;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Booking {

    private UUID id;

    private String hotelName;

    private String guestName;

    private String checkInDate;

    private String checkOutDate;

    public Booking() {
    }

    public Booking(UUID id, String hotelName, String guestName, String checkInDate, String checkOutDate) {
        this.id = id;
        this.hotelName = hotelName;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public UUID getId() {
        return id;
    }


    public String getHotelName() {
        return hotelName;
    }


    public String getGuestName() {
        return guestName;
    }


    public String getCheckInDate() {
        return checkInDate;
    }


    public String getCheckOutDate() {
        return checkOutDate;
    }


    public static Booking of(BookingRequest bookingRequest) {
        return new Booking(
                UUID.randomUUID(),
                bookingRequest.getHotelName(),
                bookingRequest.getGuestName(),
                bookingRequest.getCheckInDate(),
                bookingRequest.getCheckOutDate()
        );
    }
}
