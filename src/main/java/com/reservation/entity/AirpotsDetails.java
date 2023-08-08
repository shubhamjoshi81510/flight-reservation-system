package com.reservation.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "airpots_detail")
@Data
@Entity
public class AirpotsDetails {

    @Id
    @Column(name ="airport_id")
    private String airportId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "airport_name")
    private String airportName;

    @Column(name = "airport_city")
    private String airportCity;
}
