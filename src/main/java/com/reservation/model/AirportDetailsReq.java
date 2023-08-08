package com.reservation.model;

import lombok.Data;

import javax.persistence.Column;
@Data
public class AirportDetailsReq {

    private String airportId;
    private boolean isActive;
    private String airportName;
    private String airportCity;
}
