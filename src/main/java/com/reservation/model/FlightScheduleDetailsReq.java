package com.reservation.model;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Data
public class FlightScheduleDetailsReq {

    private String scheduleId;

    private String flightId;

    private String pilotId;
    private String sourceAirportId;
    private String destinationAirportId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String maxWatingQueu;
}
