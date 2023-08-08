package com.reservation.model;

import lombok.Data;

import javax.persistence.Column;
@Data
public class PilotDetailReq {

    private boolean isActive;
    private String pilotName;
}
