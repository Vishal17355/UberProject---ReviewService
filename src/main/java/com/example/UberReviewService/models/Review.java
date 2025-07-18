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

@Table(name = "BookingReview")
public class Review  extends BaseModel{

    @Column(nullable = false)
  private   String content;
   private double rating;


    @Override
    public String toString(){
        return "Review :"+ this.content + " " +this.rating + " " + this.createdAt;
    }
}

