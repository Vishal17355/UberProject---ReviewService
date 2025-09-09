package com.example.UberReviewService;

import com.example.uberreviewservice.Adapter.CreateReviewDtoToReviewAdapter;
import com.example.uberreviewservice.Data_Transfer_objec.CreateReviewDTO;
import com.example.uberreviewservice.Services.ReviewService;
import com.example.uberreviewservice.controllers.ReviewController;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private ReviewService reviewService;

    @Mock
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    @BeforeEach
    public void setUp() {
        // ✅ Use openMocks instead of deprecated initMocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindReviewById_Success() {
        long reviewId = 1;
        Review mockReview = Review.builder().build();
        mockReview.setId(reviewId);

        // Mocking service
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(mockReview));

        // Call controller
        ResponseEntity<?> response = reviewController.findReviewById(reviewId);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // ✅ Assuming controller returns ResponseEntity<Review>
        Review returnReview = (Review) response.getBody();
        assertEquals(reviewId, returnReview.getId());
    }
    @Test
    public void TestpublishReview_Success() {
        CreateReviewDTO requestDto = new CreateReviewDTO();
    Booking booking = new Booking();
    booking.setId(1L);
    requestDto.setBookingId(booking.getId());
        Review incomingReview= Review.builder()
            .content("Test review content")
            .rating(4.5)
            .booking(booking)
            .build();
    when(createReviewDtoToReviewAdapter.convertDto(requestDto)).thenReturn(incomingReview);
    Review savedReview = Review.builder()
                    .content(incomingReview.getContent())
                            .rating(incomingReview.getRating())
                                    .booking(incomingReview.getBooking())
                                            .build();
    when(reviewService.publishReview(incomingReview)).thenReturn(savedReview);
    ResponseEntity<?> response = reviewController.publishReview(requestDto);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
