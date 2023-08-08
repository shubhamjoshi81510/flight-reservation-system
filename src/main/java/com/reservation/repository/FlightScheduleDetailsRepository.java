package com.reservation.repository;

import com.reservation.entity.FlightDetail;
import com.reservation.entity.FlightSchedulesDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightScheduleDetailsRepository extends JpaRepository<FlightSchedulesDetail,String> {
}
