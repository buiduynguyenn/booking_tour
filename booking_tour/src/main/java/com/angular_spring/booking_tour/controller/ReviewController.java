package com.angular_spring.booking_tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular_spring.booking_tour.entity.Review;
import com.angular_spring.booking_tour.repository.ReviewRepository;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	 @Autowired
	   private ReviewRepository reviewRepository;

	   // Lấy danh sách tất cả các review
	   @GetMapping
	   public List<Review> getAllReviews() {
	       return reviewRepository.findAll();
	   }

	   // Thêm review mới
	   @PostMapping
	   public ResponseEntity<Review> createReview(@RequestBody Review review) {
	       Review savedReview = reviewRepository.save(review);
	       return ResponseEntity.ok(savedReview);
	   }

	   // Cập nhật review
	   @PutMapping("/{id}")
	   public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
	       Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));

	       review.setRating(reviewDetails.getRating());
	       review.setComment(reviewDetails.getComment());

	       final Review updatedReview = reviewRepository.save(review);
	       return ResponseEntity.ok(updatedReview);
	   }

	   // Xóa review
	   @DeleteMapping("/{id}")
	   public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
	       reviewRepository.deleteById(id);
	       return ResponseEntity.noContent().build();
	   }
}
