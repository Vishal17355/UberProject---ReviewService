package com.example.UberReviewService.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "BookingReview")
public class Review {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY )

     long id;
    @Column(nullable = false)
    String content;
    double rating;
    @Column(nullable = false)
            @Temporal(TemporalType.TIMESTAMP) // this tell spring about the format of date object to be stored
            @CreatedDate   // this annotation tell spring that only it for object creation
    Date createdAt;
    @Column(nullable = false)
            @Temporal(TemporalType.TIMESTAMP)
            @LastModifiedDate
    Date updatedAT;
}

