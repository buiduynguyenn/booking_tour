package com.angular_spring.booking_tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular_spring.booking_tour.Service.RegisterService;
import com.angular_spring.booking_tour.entity.User;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    // Phương thức đăng ký
    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) {
        String result = registerService.registerUser(user);
        if ("Username already exists".equals(result)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result); // HTTP 409: Conflict
        }
        return ResponseEntity.ok(result); // HTTP 200: Success
    }
}
