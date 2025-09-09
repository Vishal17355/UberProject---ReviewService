package com.example.uberreviewservice.repositories;


import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository

public interface   BookingRepository extends JpaRepository<Booking, Long> {





}
