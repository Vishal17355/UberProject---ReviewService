package com.example.uberreviewservice.Adapter;

import com.example.uberreviewservice.Data_Transfer_objec.CreateReviewDTO;
import com.example.uberreviewservice.models.Review;

public interface CreateReviewDtoToReviewAdapter {


    public Review convertDto(CreateReviewDTO createReviewDTO);

}
