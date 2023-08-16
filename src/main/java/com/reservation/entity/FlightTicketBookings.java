package com.reservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "flight_ticket_booking")
@Data
@Entity
public class FlightTicketBookings {

    @Id
    @Column(name ="booking_id")
    private String bookingId;

    @ManyToOne
    @JoinColumn (name ="schedule_id")
    private FlightSchedulesDetail flightSchedulesDetail;

    @Column(name ="customer_name")
    private String customerName;

    @Column(name ="creation_time")
    private LocalDateTime creationTime;

    @Column(name ="status")
    private String status;

}
