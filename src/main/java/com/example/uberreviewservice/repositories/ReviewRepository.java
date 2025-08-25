package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

// repository use to communicate with database
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

     Integer countAllByRatingLessThanEqual(Integer givenRating);
     List<Review> findAllByRatingLessThanEqual(Integer givenRating);

     List<Review> findAllByCreatedAtBefore(Date date);



}