package com.example.booking.controllers;

import com.example.booking.models.Booking;
import com.example.booking.repositories.BookingRepository;
import com.example.booking.services.BookingService;
import com.google.gson.Gson;

import java.util.List;
import java.util.UUID;

import static spark.Spark.*;

public class BookingController {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        BookingService service = new BookingService(new BookingRepository());

        post("/bookings", (req, res) -> {
            Booking booking = gson.fromJson(req.body(), Booking.class);
            Booking created = service.createBooking(
                    booking.getUserId(),
                    booking.getHotelName(),
                    booking.getCheckInDate(),
                    booking.getCheckOutDate()
            );
            res.status(201);
            return gson.toJson(created);
        });

        get("/bookings/:userId", (req, res) -> {
            String userId = req.params(":userId");
            List<Booking> bookings = service.getUserBookings(userId);
            res.status(200);
            return gson.toJson(bookings);
        });

        delete("/bookings/:bookingId", (req, res) -> {
            UUID bookingId = UUID.fromString(req.params(":bookingId"));
            boolean deleted = service.cancelBooking(bookingId);
            if (deleted) {
                res.status(204);
            } else {
                res.status(404);
            }
            return "";
        });
    }
}

