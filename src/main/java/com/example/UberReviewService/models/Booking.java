package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    private Review review;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;

    private long totalDist;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;
}
