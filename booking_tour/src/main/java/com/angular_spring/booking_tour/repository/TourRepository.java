package com.angular_spring.booking_tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular_spring.booking_tour.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

}
