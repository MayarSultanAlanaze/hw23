package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

        private final AuthService authService;

        @GetMapping ("/get")
        public ResponseEntity getAllUsers(){
            List<User>users=authService.getAllUser();
            return ResponseEntity.status(200).body(users);
        }

        @PostMapping ("/register")
        public ResponseEntity register(@RequestBody  User user){

            authService.register(user);
            return ResponseEntity.status(200).body("user registered");
        }

        @PostMapping("/admin")
        public ResponseEntity admin(){

            return ResponseEntity.status(200).body("welcome admin");
        }

        @PostMapping("/user")
        public ResponseEntity user(){

            return ResponseEntity.status(200).body("welcome user");
        }

        @PostMapping("/login")
        public ResponseEntity login(){

            return ResponseEntity.status(200).body("you logged in");
        }

        @PostMapping("/logout")
        public ResponseEntity logout(){

            return ResponseEntity.status(200).body("logging out succeed");
        }
    }
