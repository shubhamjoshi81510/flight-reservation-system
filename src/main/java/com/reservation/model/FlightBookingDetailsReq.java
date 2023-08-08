package com.reservation.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
@Data
public class FlightBookingDetailsReq {

    private String scheduleId;

    private String customerName;

    private LocalDateTime creationTime;

    private String status;
}
