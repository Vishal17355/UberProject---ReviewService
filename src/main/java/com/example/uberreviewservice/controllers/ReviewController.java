package com.example.uberreviewservice.controllers;

import com.example.uberreviewservice.Adapter.CreateReviewDtoToReviewAdapter;
import com.example.uberreviewservice.Data_Transfer_objec.CreateReviewDTO;
import com.example.uberreviewservice.Data_Transfer_objec.ReviewDto;
import com.example.uberreviewservice.Services.ReviewService;
import com.example.uberreviewservice.models.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    public ReviewController(ReviewService reviewService , CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    // ✅ Create a review
    @PostMapping
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDTO request) {
        Review incomingReview = this.createReviewDtoToReviewAdapter.convertDto(request);
        if(incomingReview == null){
            return new ResponseEntity<>("invalid arguments" , HttpStatus.BAD_REQUEST);
        }
        Review review = reviewService.publishReview(incomingReview);
        ReviewDto response = ReviewDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .booking(review.getBooking().getId())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAT())
                .build();

        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ✅ Get all reviews
    @GetMapping
    public ResponseEntity<List<Review>> findAllReviews() {
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews , HttpStatus.OK);
    }

    // ✅ Get review by ID
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable Long reviewId) {
        try{
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            if(review.isPresent()){
                return new ResponseEntity<>(review , HttpStatus.OK);
            }else{
                return new ResponseEntity<>( " Review not found" ,HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    // ✅ D  elete review by ID
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId) {
        boolean isDeleted = reviewService.deleteReviewById(reviewId);
        if (isDeleted) {
            return ResponseEntity.ok("Review deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to delete review");
        }
    }
}