package com.reservation.controller;

import com.reservation.entity.*;
import com.reservation.model.*;
import com.reservation.service.FlightReservationServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {


    @Autowired
    private FlightReservationServiceLogic flightReservationServiceLogic;

    @PostMapping("/createFlight")
    public  FlightDetail createFlight(@RequestBody FlightDetailsReq flightDetailsReq){
        FlightDetail flightDetail = flightReservationServiceLogic.createNewFlight(flightDetailsReq);
        return flightDetail;

    }

    @PostMapping("/createAirport")
    public AirpotsDetails createAirport(@RequestBody AirportDetailsReq airportDetailsReq){
        AirpotsDetails airpotsDetails = flightReservationServiceLogic.createNewAirport(airportDetailsReq);
        return airpotsDetails;

    }
    @PostMapping("/createPilot")
    public PilotDetail createNewPilot(@RequestBody PilotDetailReq pilotDetailReq){
        PilotDetail pilotDetail=flightReservationServiceLogic.createNewPilot(pilotDetailReq);
        return pilotDetail;
    }

    @PostMapping("/createFlightSchedule")
    public FlightSchedulesDetail  createNewflight (@RequestBody FlightScheduleDetailsReq flightScheduleDetailsReq){
        FlightSchedulesDetail flightSchedulesDetail=flightReservationServiceLogic.createFlightSchedule(flightScheduleDetailsReq);
        return flightSchedulesDetail;

    }

    @PostMapping("/createNewBooking")
    public FlightTicketBookings createNewBooking(@RequestBody FlightBookingDetailsReq flightBookingDetailsReq){
        FlightTicketBookings flightTicketBookings=flightReservationServiceLogic.ticketBooking(flightBookingDetailsReq);
        return flightTicketBookings;
    }


}
