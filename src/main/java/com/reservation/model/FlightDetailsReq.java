package com.reservation.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class FlightDetailsReq {


    private String FlightName;
    private boolean isActive;
    private String maxCapacity;
}
