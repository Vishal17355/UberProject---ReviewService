package com.example.uberreviewservice.Data_Transfer_objec;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDTO {
    private String content ;

    private String rating;

    private long bookingId;


}
