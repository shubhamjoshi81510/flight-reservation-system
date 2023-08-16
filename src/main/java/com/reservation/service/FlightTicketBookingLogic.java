package com.reservation.service;

import com.reservation.entity.FlightSchedulesDetail;
import com.reservation.entity.FlightTicketBookings;
import com.reservation.exception.BadRequestException;
import com.reservation.model.FlightBookingDetailsReq;
import com.reservation.repository.FlightScheduleDetailsRepository;
import com.reservation.repository.FlightTicketBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;



@Service
public class FlightTicketBookingLogic {

    @Autowired
    private FlightScheduleDetailsRepository flightScheduleDetailsRepository;
    @Autowired
    private FlightTicketBookingsRepository flightTicketBookingsRepository;


    public FlightTicketBookings ticketBooking(FlightBookingDetailsReq flightBookingDetailsReq){
        UUID uniqeId =UUID.randomUUID();
        FlightTicketBookings flightTicketBookings=new FlightTicketBookings();
        flightTicketBookings.setBookingId(uniqeId.toString());
        FlightSchedulesDetail flightSchedulesDetail= flightScheduleDetailsRepository.findById(flightBookingDetailsReq.getScheduleId()).orElse(null);

        if(flightSchedulesDetail == null) {
            throw new BadRequestException("Schedule With ID: "+ flightBookingDetailsReq.getScheduleId() + " does not exists");
        }

        int confirmedAndWaitingTickets = flightTicketBookingsRepository.countByCurrentStatusNot(2);

        // review again if error occur
        flightTicketBookings.setFlightSchedulesDetail(flightSchedulesDetail);
        flightTicketBookings.setCustomerName(flightBookingDetailsReq.getCustomerName());
        flightTicketBookings.setCreationTime(LocalDateTime.now());
        flightTicketBookings.setStatus(flightTicketBookings.getStatus());
        flightTicketBookingsRepository.save(flightTicketBookings);
        return flightTicketBookings;

    }
}
