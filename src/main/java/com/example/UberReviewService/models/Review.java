package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "BookingReview")
public class Review {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY )

    private long id;
    @Column(nullable = false)
  private   String content;
   private double rating;
    @Column(nullable = false)
            @Temporal(TemporalType.TIMESTAMP) // this tell spring about the format of date object to be stored
            @CreatedDate   // this annotation tell spring that only it for object creation
 private    Date createdAt;
    @Column(nullable = false)
            @Temporal(TemporalType.TIMESTAMP)
            @LastModifiedDate
  private   Date updatedAT;

    @Override
    public String toString(){
        return "Review :"+ this.content + " " +this.rating + " " + this.createdAt;
    }
}

