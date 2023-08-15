package com.reservation.controller;

import com.reservation.entity.*;
import com.reservation.model.*;
import com.reservation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @Autowired
    private FlightDetailLogic flightReservationServiceLogic;
    @PostMapping("/flight")
    public  FlightDetail createFlight(@RequestBody FlightDetailsReq flightDetailsReq){
        FlightDetail flightDetail = flightReservationServiceLogic.createNewFlight(flightDetailsReq);
        return flightDetail;
    }
    @Autowired
    private AirpotsDetailLogic airportDetailLogic;
    @PostMapping("/airport")
    public AirpotsDetails createAirport(@RequestBody AirportDetailsReq airportDetailsReq){
        AirpotsDetails airpotsDetails = airportDetailLogic.createNewAirport(airportDetailsReq);
        return airpotsDetails;

    }

    @Autowired
    private PilotDetailLogic pilotDetailLogic;
    @PostMapping("/pilot")
    public PilotDetail createNewPilot(@RequestBody PilotDetailReq pilotDetailReq){
        PilotDetail pilotDetail=pilotDetailLogic.createNewPilot(pilotDetailReq);
        return pilotDetail;
    }
    @Autowired
    private FlightScheduleDetailLogic flightScheduleDetailLogic;
    @PostMapping("/flightSchedule")
    public FlightSchedulesDetail  createNewflight (@RequestBody FlightScheduleDetailsReq flightScheduleDetailsReq){
        FlightSchedulesDetail flightSchedulesDetail=flightScheduleDetailLogic.createFlightSchedule(flightScheduleDetailsReq);
        return flightSchedulesDetail;

    }


    @Autowired FlightTicketBookingLogic flightTicketBookingLogic;
    @PostMapping("/booking")
    public FlightTicketBookings createNewBooking(@RequestBody FlightBookingDetailsReq flightBookingDetailsReq){
        FlightTicketBookings flightTicketBookings= flightTicketBookingLogic.ticketBooking(flightBookingDetailsReq);
        return flightTicketBookings;
    }
}
