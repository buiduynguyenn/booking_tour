package com.angular_spring.booking_tour.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;

	   private Long userId; // ID của người dùng đã đánh giá
	   private Long tourId; // ID của tour được đánh giá

	   private int rating; // Đánh giá từ 1 đến 5
	   private String comment; // Bình luận

	   // Getter và Setter

	   public Long getId() {
	       return id;
	   }

	   public void setId(Long id) {
	       this.id = id;
	   }

	   public Long getUserId() {
	       return userId;
	   }

	   public void setUserId(Long userId) {
	       this.userId = userId;
	   }

	   public Long getTourId() {
	       return tourId;
	   }

	   public void setTourId(Long tourId) {
	       this.tourId = tourId;
	   }

	   public int getRating() {
	       return rating;
	   }

	   public void setRating(int rating) {
	       this.rating = rating;
	   }

	   public String getComment() {
	       return comment;
	   }

	   public void setComment(String comment) {
	       this.comment = comment;
	   }
}
