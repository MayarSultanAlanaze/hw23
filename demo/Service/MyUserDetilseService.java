package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


    @Service
    @RequiredArgsConstructor
    public class MyUserDetilseService implements UserDetailsService {

        private final RepositoryUser repositoryUser ;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user=repositoryUser.findUserByUsername(username);
            if(user==null){
                throw new UsernameNotFoundException("wrong username or password");
            }
            return user;
        }
    }
