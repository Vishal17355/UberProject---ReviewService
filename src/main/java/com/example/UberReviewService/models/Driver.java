package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver extends BaseModel {

    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();
}
