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

import com.angular_spring.booking_tour.entity.Booking;
import com.angular_spring.booking_tour.repository.BookingRepository;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	 @Autowired
	   private BookingRepository bookingRepository;

	   // Lấy danh sách tất cả các booking
	   @GetMapping
	   public List<Booking> getAllBookings() {
	       return bookingRepository.findAll();
	   }

	   // Thêm booking mới
	   @PostMapping
	   public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
	       Booking savedBooking = bookingRepository.save(booking);
	       return ResponseEntity.ok(savedBooking);
	   }

	   // Cập nhật booking
	   @PutMapping("/{id}")
	   public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
	       Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));

	       booking.setUserId(bookingDetails.getUserId());
	       booking.setTourId(bookingDetails.getTourId());
	       booking.setNumberOfPeople(bookingDetails.getNumberOfPeople());
	       booking.setTotalPrice(bookingDetails.getTotalPrice());

	       final Booking updatedBooking = bookingRepository.save(booking);
	       return ResponseEntity.ok(updatedBooking);
	   }

	   // Xóa booking
	   @DeleteMapping("/{id}")
	   public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
	       bookingRepository.deleteById(id);
	       return ResponseEntity.noContent().build();
	   }
}
