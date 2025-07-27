package com.example.UberReviewService.Services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Reviewservice implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public Reviewservice(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
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
     Optional <Booking> b =bookingRepository.findById(6l);
     if(b.isPresent()){
         bookingRepository.delete(b.get());
     }
    }
}
