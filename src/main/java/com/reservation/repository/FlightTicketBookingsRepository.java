package com.reservation.repository;

import com.reservation.entity.FlightTicketBookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightTicketBookingsRepository extends JpaRepository< FlightTicketBookings,String> {
}
