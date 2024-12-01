package com.angular_spring.booking_tour.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.angular_spring.booking_tour.Service.LoginService;
import com.angular_spring.booking_tour.util.JwtUtil;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> user) {
        String username = user.get("username");
        String password = user.get("password");

        // Xác thực và lấy token nếu đúng thông tin đăng nhập
        String token = loginService.authenticate(username, password);

        // Nếu token không null, tiến hành giải mã
        if (token != null) {
            try {
                // Giải mã token để lấy thông tin claims
                Claims claims = jwtUtil.decodeToken(token);
                System.out.println("Giải mã token: " + claims);

                 // Lấy thông tin từ claims (ví dụ: username)
                String decodedUsername = claims.getSubject();
                System.out.println("Decoded Username: " + decodedUsername);

                // Trả về token và thông tin đã giải mã
                return ResponseEntity.ok(Map.of(
                        "token", token,
                        "username", decodedUsername, // Trả về thông tin người dùng đã giải mã
                        "claims", claims // Trả về toàn bộ claims nếu cần
                ));
            } catch (Exception e) {
                // Nếu token không hợp lệ, trả về lỗi
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token không hợp lệ");
            }
        } else {
            // Nếu thông tin đăng nhập không chính xác, trả về lỗi
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai tên đăng nhập hoặc mật khẩu");
        }
    }
}
