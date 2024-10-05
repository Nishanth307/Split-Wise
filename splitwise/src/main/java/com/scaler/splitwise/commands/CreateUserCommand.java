package com.scaler.splitwise.commands;

import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Component;

import com.scaler.splitwise.controllers.UserController;
import com.scaler.splitwise.dtos.CreateUserRequest;
import com.scaler.splitwise.models.User;

import lombok.AllArgsConstructor;

//step-2 creare the concrete command classes
@Component
@AllArgsConstructor
public class CreateUserCommand implements Comand{
      private UserController userController;
      @Override
      public boolean matches(String input) {
            List<String> tokens = Arrays.stream(input.split(" ")).toList();
            // register nishanth abc@gmail.com 1234 999999991
            String comand = tokens.get(0);
            if (!comand.equals(Commands.REGISTER_USER_COMMAND) || tokens.size()<5){
                  return false;
            }
            return true;
      }

      @Override
      public void execute(String input) {
            System.out.println("Executing create user command...");
            List<String> tokens = Arrays.stream(input.split(" ")).toList();
            CreateUserRequest request = CreateUserRequest
                                                      .builder()
                                                      .name(tokens.get(1))
                                                      .email(tokens.get(2))
                                                      .password(tokens.get(3))
                                                      .phoneNo(tokens.get(4))
                                                      .build();
            User user = userController.createUserMethod(request);
            System.out.println("Created user with name"+user.getName()+ " id "+user.getId());

      }
      
}
