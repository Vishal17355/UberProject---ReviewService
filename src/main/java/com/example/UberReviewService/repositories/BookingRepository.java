package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository

public interface   BookingRepository extends JpaRepository<Booking, Long> {



    List<Booking> findAllBydriverId(Long driverId);


    List<Booking> findAllByDriverIn(List<Driver> drivers) ;
}
