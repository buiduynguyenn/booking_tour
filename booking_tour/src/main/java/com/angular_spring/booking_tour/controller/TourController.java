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

import com.angular_spring.booking_tour.entity.Tour;
import com.angular_spring.booking_tour.repository.TourRepository;

@RestController
@RequestMapping("/api/tours")
public class TourController {
	@Autowired
    private TourRepository tourRepository;

    // Lấy danh sách tất cả các tour
    @GetMapping
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    // Lấy tour theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found"));
        return ResponseEntity.ok(tour);
    }

    // Thêm tour mới
    @PostMapping
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        Tour savedTour = tourRepository.save(tour);
        return ResponseEntity.ok(savedTour);
    }

    // Cập nhật tour
    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour tourDetails) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found"));
        
        tour.setName(tourDetails.getName());
        tour.setDescription(tourDetails.getDescription());
        tour.setPrice(tourDetails.getPrice());
        tour.setDuration(tourDetails.getDuration());
        tour.setLocation(tourDetails.getLocation());
        
        final Tour updatedTour = tourRepository.save(tour);
        return ResponseEntity.ok(updatedTour);
    }

    // Xóa tour
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        tourRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
