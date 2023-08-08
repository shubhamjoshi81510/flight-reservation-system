package com.reservation.service;

import com.reservation.entity.*;
import com.reservation.model.*;
import com.reservation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;
@Service
public class FlightReservationServiceLogic {

    @Autowired
    private FlightDetailRepository flightDetailRepository;
    @Autowired
     private AirpotsDetailsRepository airpotsDetailsRepository;
    @Autowired
    private PilotDetailRepository pilotDetailRepository;
    @Autowired
    FlightScheduleDetailsRepository flightScheduleDetailsRepository;

    @Autowired
    private FlightTicketBookingsRepository flightTicketBookingsRepository;






    public FlightDetail createNewFlight(FlightDetailsReq flightDetailsReq) {
        UUID uniqueId = UUID.randomUUID();
        FlightDetail flightDetail = new FlightDetail();
        flightDetail.setFlightName(flightDetailsReq.getFlightName());
        flightDetail.setFlightId(uniqueId.toString());
        flightDetail.setActive(true);
        flightDetail.setMaxCapacity(flightDetailsReq.getMaxCapacity());
        flightDetailRepository.save(flightDetail);
        return flightDetail;
    }

    public AirpotsDetails createNewAirport(AirportDetailsReq airportDetailsReq) {

        UUID uniqueId = UUID.randomUUID();
        AirpotsDetails airportsDetails = new AirpotsDetails();
        airportsDetails.setAirportCity(airportDetailsReq.getAirportCity());
        airportsDetails.setAirportId(uniqueId.toString());
        airportsDetails.setAirportName(airportDetailsReq.getAirportName());
        airportsDetails.setActive(airportDetailsReq.isActive());
        airpotsDetailsRepository.save(airportsDetails);
        return airportsDetails;

    }
    public PilotDetail createNewPilot (PilotDetailReq pilotDetailReq){
        UUID uniqueId = UUID.randomUUID();
        PilotDetail pilotDetail = new PilotDetail();
        pilotDetail.setPilotName(pilotDetailReq.getPilotName());
        pilotDetail.setPilotId(uniqueId.toString());
        pilotDetail.setActive(true);
        pilotDetailRepository.save(pilotDetail);
        return pilotDetail;

    }


    public FlightSchedulesDetail createFlightSchedule (FlightScheduleDetailsReq flightScheduleDetailsReq){
        UUID uniqueId = UUID.randomUUID();
        FlightSchedulesDetail flightSchedulesDetail=new FlightSchedulesDetail();
        flightSchedulesDetail.setScheduleId(uniqueId.toString());
        PilotDetail pilotDetail= pilotDetailRepository.findById(flightScheduleDetailsReq.getPilotId()).get();
        AirpotsDetails airpotsDetails = airpotsDetailsRepository.findById(flightScheduleDetailsReq.getSourceAirportId()).get();
        AirpotsDetails airpotsDetails1 = airpotsDetailsRepository.findById(flightScheduleDetailsReq.getDestinationAirportId()).get();
        FlightDetail flightDetail = flightDetailRepository.findById((flightScheduleDetailsReq.getFlightId())).get();

        flightSchedulesDetail.setArrivalTime(flightScheduleDetailsReq.getArrivalTime());
        flightSchedulesDetail.setDepartureTime(flightScheduleDetailsReq.getDepartureTime());
        flightSchedulesDetail.setMaxWatingQueu(flightScheduleDetailsReq.getMaxWatingQueu());
        flightSchedulesDetail.setFlightDetail(flightDetail);
        flightSchedulesDetail.setPilotDetail(pilotDetail);
        flightSchedulesDetail.setSourceAirportId(airpotsDetails);
        flightSchedulesDetail.setDestinationAirportId(airpotsDetails1);
        flightScheduleDetailsRepository.save(flightSchedulesDetail);
        return flightSchedulesDetail;
    }

    public FlightTicketBookings ticketBooking(FlightBookingDetailsReq flightBookingDetailsReq){
        UUID uniqeId =UUID.randomUUID();
        FlightTicketBookings flightTicketBookings=new FlightTicketBookings();
        flightTicketBookings.setBookingId(uniqeId.toString());
        FlightSchedulesDetail flightSchedulesDetail= flightScheduleDetailsRepository.findById(flightBookingDetailsReq.getScheduleId()).get();
        flightTicketBookings.setScheduleId(flightSchedulesDetail);
        flightTicketBookings.setCustomerName(flightBookingDetailsReq.getCustomerName());
        flightTicketBookings.setCreationTime(LocalDateTime.now());
        flightTicketBookings.setStatus(flightTicketBookings.getStatus());
        flightTicketBookingsRepository.save(flightTicketBookings);
        return flightTicketBookings;

    }
}







