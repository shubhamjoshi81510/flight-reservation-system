package com.reservation.service;

import com.reservation.entity.*;
import com.reservation.model.*;
import com.reservation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class FlightDetailLogic {

    @Autowired
    private FlightDetailRepository flightDetailRepository;
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








}







