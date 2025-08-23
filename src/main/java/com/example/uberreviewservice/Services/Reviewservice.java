package com.example.uberreviewservice.Services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class Reviewservice implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;
    public Reviewservice(ReviewRepository reviewRepository, BookingRepository bookingRepository , DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository= driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("***************");

//        Review r = Review.builder()
//                .content("Amazing ride quality")
//                .rating(5.0)
//                .build();
//
//        Booking b = Booking.builder()
//                .review(r)
//                .endtime(new Date())
//                .build();
//
//        bookingRepository.save(b); // No need to save Review separately due to Cascade.ALL
//
//        List<Review> reviews = reviewRepository.findAll();
//        for (Review review : reviews) {
//            System.out.println(review.getContent());
//        }
//
//        reviewRepository.deleteById(2L); // Only if this ID exists
//     Optional <Booking> b =bookingRepository.findById(6l);
//     if(b.isPresent()){
//
//     }

    //    bookingRepository.delete(b.get());
//
//     Optional<Driver> driver= driverRepository.findById(1L  );
//     if (driver.isPresent()){
//        System.out.println(driver.get().getName());
//        List<Booking> b=  driver.get().getBookings();
////         List<Booking> bookings = bookingRepository.findAllBydriverId(1L);
//         for(Booking booking : b){
//            System.out.println(booking.getBookingStatus());}
//    }
// Optional <Driver> d = driverRepository.hblFindByIdAndLicenseNumber(1L , "Dl1212");
//        if (d.isPresent()) {
//            System.out.println(d.get().getName());
//        } else {
//            System.out.println("Driver not found.");
//        }


        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L , 2L , 3L , 4L , 5L));
        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);

  //    List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);
     for (Driver driver : drivers){
         System.out.println(driver.getBookings().size());
       final  Set<Booking> bookings=driver.getBookings();
        bookings.forEach((booking -> System.out.println(booking.getId())));
     }

    }
}
