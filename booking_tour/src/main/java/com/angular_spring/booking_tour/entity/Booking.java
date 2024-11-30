package com.angular_spring.booking_tour.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;

	   private Long userId; // ID của người dùng đã đặt tour
	   private Long tourId; // ID của tour đã đặt

	   private int numberOfPeople; // Số lượng người đặt tour
	   private double totalPrice; // Tổng giá trị đơn hàng

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

	   public int getNumberOfPeople() {
	       return numberOfPeople;
	   }

	   public void setNumberOfPeople(int numberOfPeople) {
	       this.numberOfPeople = numberOfPeople;
	   }

	   public double getTotalPrice() {
	       return totalPrice;
	   }

	   public void setTotalPrice(double totalPrice) {
	       this.totalPrice = totalPrice;
	   }
}
