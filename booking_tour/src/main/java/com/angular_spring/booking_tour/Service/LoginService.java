package com.angular_spring.booking_tour.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.angular_spring.booking_tour.entity.User;
import com.angular_spring.booking_tour.repository.UserRepository;
import com.angular_spring.booking_tour.util.JwtUtil;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            return jwtUtil.generateToken(username); // Trả về token nếu đúng username/password
        }
        return null;
    }
}
