package com.example.uberreviewservice.repositories;


import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
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
