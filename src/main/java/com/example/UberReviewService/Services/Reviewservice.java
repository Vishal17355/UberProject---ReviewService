package com.example.UberReviewService.Services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Reviewservice implements CommandLineRunner {
    private  ReviewRepository reviewRepository ;
    public Reviewservice(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("***************");
        Review r = Review.builder()
                .content("Amazon ride quality")
                .rating(5.0)
                .build(); // code to crreate plan  java object
        System.out.println(r);
        reviewRepository.save(r); // this code execute sql query;
         List<Review> reviews = reviewRepository.findAll();
        for (Review review: reviews){
            System.out.println(r.getContent());
        }
        reviewRepository.deleteById(2L);
    }
}
