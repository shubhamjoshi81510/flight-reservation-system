package com.reservation.service;

import com.reservation.entity.AirpotsDetails;
import com.reservation.model.AirportDetailsReq;
import com.reservation.repository.AirpotsDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class AirpotsDetailLogic {
    @Autowired
    private AirpotsDetailsRepository airpotsDetailsRepository;

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
}
