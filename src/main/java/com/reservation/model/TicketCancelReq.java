package com.reservation.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class TicketCancelReq {
    private String  booking_id;
}
