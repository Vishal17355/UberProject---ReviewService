package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "BookingReview")

public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private double rating;

    @OneToOne(cascade = {CascadeType.ALL} , fetch = FetchType.LAZY)
@JoinColumn(nullable = false)
    private Booking booking;

    @Override
    public String toString() {
        return "Review: " + this.content + " " + this.rating + " "  + " booking :" + this.booking.getId() + " " + this.createdAt;
    }
}
