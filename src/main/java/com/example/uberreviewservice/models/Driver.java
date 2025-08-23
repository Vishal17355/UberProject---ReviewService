package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import  org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
   import  org.springframework.data.repository.cdi.Eager;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "bookings")
public class Driver extends BaseModel {
    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Booking> bookings = new HashSet<>();
}
