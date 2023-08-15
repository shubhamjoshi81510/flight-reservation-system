package com.reservation.service;

import com.reservation.entity.FlightTicketBookings;
import com.reservation.model.TicketCancelReq;
import com.reservation.repository.FlightScheduleDetailsRepository;
import com.reservation.repository.FlightTicketBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CancelTicketLogic {
    @Autowired
    private FlightTicketBookingsRepository flightTicketBookingsRepository;

    public String cancelTicket (String bookingId ){
        FlightTicketBookings flightTicketBookings=  flightTicketBookingsRepository.findById(bookingId).get();

    }
}
