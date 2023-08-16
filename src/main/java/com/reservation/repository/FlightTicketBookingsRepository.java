package com.reservation.repository;

import com.reservation.entity.FlightTicketBookings;
import com.reservation.model.FlightBookingDetailsReq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightTicketBookingsRepository extends JpaRepository< FlightTicketBookings,String> {

    Optional<FlightTicketBookings> findFirstByFlightScheduleAndCurrentStatusOrderByCreatedAtAsc(FlightSchedule flightSchedule, Integer currentStatus);
}
