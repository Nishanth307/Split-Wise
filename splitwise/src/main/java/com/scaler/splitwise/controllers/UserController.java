package com.scaler.splitwise.controllers;
import com.scaler.splitwise.services.UserService;

import org.springframework.stereotype.Controller;

import com.scaler.splitwise.dtos.CreateUserRequest;
import com.scaler.splitwise.models.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class UserController {
      private UserService UserService;
      public User createUserMethod(CreateUserRequest request){
            return UserService.createUser(request.toUser());
      }
}
