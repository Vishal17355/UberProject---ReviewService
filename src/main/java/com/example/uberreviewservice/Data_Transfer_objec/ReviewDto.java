package com.example.uberreviewservice.Data_Transfer_objec;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private long id ;
    private String content ;
    private  double rating;

    private long booking;
    private Date createdAt;
    private  Date updatedAt;
}
