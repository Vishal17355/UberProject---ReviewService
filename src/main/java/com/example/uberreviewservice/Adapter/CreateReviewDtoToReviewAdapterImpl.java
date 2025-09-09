package com.example.uberreviewservice.Adapter;

import com.example.uberreviewservice.Data_Transfer_objec.CreateReviewDTO;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{

    private BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDTO createReviewDTO) {
        Optional<Booking> booking =bookingRepository.findById(Long.valueOf(createReviewDTO.getBookingId()));
        if(booking.isEmpty()){
            return null;
        }
        Review review = Review.builder()
                .rating(Double.parseDouble(createReviewDTO.getRating()))
                .booking(booking.get())
                .content(createReviewDTO.getContent())
                .build();
        return review;
    }
}
