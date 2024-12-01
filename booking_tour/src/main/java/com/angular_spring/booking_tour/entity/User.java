package com.angular_spring.booking_tour.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password; // Mật khẩu nên được mã hóa trong thực tế
    private String email;
    
    private String fullName;

    private String role; // Thay đổi từ Role thành String

    // Getter và Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getFullName() {
        return fullName;
     }
    
     public void setFullName(String fullName) {
         this.fullName = fullName; 
     }
    
     public String getRole() { 
         return role; 
     }
    
     public void setRole(String role) { 
         this.role = role; 
     }
}
