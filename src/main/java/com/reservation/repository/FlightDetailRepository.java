package com.reservation.repository;

import com.reservation.entity.FlightDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDetailRepository extends JpaRepository< FlightDetail,String > {
}
