package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final RepositoryUser repositoryUser;

    public List<User>getAllUser(){
        List<User>users=repositoryUser.findAll();
        return users;
    }
    public void register(User user){
        user.setRole("USER");
        String hash=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        repositoryUser.save(user);
    }
        }
