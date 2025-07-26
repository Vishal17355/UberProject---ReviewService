package com.example.UberReviewService.models;

import jakarta.persistence.*;
import jakarta.persistence.Temporal;
import lombok.*;


import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Booking extends BaseModel{
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Review driver;
    @Enumerated(value = EnumType.STRING)

    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date starttime;


@Temporal(value = TemporalType.TIMESTAMP)
    private Date endtime;

    private long totalDist;

}
