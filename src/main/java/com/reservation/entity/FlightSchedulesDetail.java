package com.reservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "flight_schedules_details")
@Entity
@Data
public class FlightSchedulesDetail {

    @Id
    @Column(name ="schedule_id")
    private String scheduleId;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightDetail flightDetail;


    @ManyToOne
    @JoinColumn(name ="pilot_id")
    private PilotDetail pilotDetail;


    @ManyToOne
    @JoinColumn (name ="source_airport_id")
    private AirpotsDetails sourceAirport;

    @ManyToOne
    @JoinColumn (name ="destination_airport_id")
    private AirpotsDetails destinationAirport;

    @Column(name ="departure_time")
    private LocalDateTime departureTime;

    @Column(name ="arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name ="max_waiting_queu")
    private String maxWatingQueu;

}
