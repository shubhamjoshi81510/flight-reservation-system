package com.reservation.service;

import com.reservation.entity.AirpotsDetails;
import com.reservation.entity.FlightDetail;
import com.reservation.entity.FlightSchedulesDetail;
import com.reservation.entity.PilotDetail;
import com.reservation.model.FlightScheduleDetailsReq;
import com.reservation.repository.AirpotsDetailsRepository;
import com.reservation.repository.FlightDetailRepository;
import com.reservation.repository.FlightScheduleDetailsRepository;
import com.reservation.repository.PilotDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class FlightScheduleDetailLogic {

    @Autowired
    private PilotDetailRepository pilotDetailRepository;
    @Autowired
    private AirpotsDetailsRepository airpotsDetailsRepository;

    @Autowired
    private FlightDetailRepository flightDetailRepository;

    @Autowired
    private FlightScheduleDetailsRepository flightScheduleDetailsRepository;
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
        flightSchedulesDetail.setSourceAirport(airpotsDetails);
        flightSchedulesDetail.setDestinationAirport(airpotsDetails1);
        flightScheduleDetailsRepository.save(flightSchedulesDetail);
        return flightSchedulesDetail;
    }
}
