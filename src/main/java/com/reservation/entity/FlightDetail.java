package com.reservation.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "flightDetail")
@Data
@Entity
public class FlightDetail {

    @Id
    @Column(name ="Flight_id")
    private String flightId;

    @Column(name = "flight_name")
    private String FlightName;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "max_capacity")
    private String maxCapacity;
}
