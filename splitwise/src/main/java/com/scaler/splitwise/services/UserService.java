package com.scaler.splitwise.services;

import org.springframework.stereotype.Service;

import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
      private UserRepository userRepository;
      public User createUser(User user){
            return userRepository.save(user);
      }
}
