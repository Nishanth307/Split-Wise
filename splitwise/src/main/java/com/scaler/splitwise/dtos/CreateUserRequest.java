package com.scaler.splitwise.dtos;

import com.scaler.splitwise.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateUserRequest {
      private String name;
      private String email;
      private String phoneNo;
      private String password;
      public User toUser() {
            return User
            .builder()
            .name(name)
            .phoneNo(phoneNo)
            .email(email)
            .password(password)
            .build();
      }
}
