package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repository use to communicate with database
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


}
