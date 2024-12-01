package com.angular_spring.booking_tour.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular_spring.booking_tour.entity.User;
import com.angular_spring.booking_tour.repository.RegisterRepository;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;
    public String registerUser(User user) {
        registerRepository.save(user);

        return "User registered successfully";
    }
}
