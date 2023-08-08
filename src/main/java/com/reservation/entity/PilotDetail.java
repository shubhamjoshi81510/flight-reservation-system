package com.reservation.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "pilot_detail")
@Data
@Entity
public class PilotDetail {
    @Id
    @Column(name ="pilot_id")
    private String pilotId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "pilot_name")
    private String pilotName;
}
