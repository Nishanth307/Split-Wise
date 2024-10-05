package com.scaler.splitwise.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name="gang")
public class Group extends BaseModel{
      private String name;
      @ManyToOne
      private User createdBy;
      @ManyToMany
      private List<User> admins = new ArrayList<>();
      @ManyToMany
      private List<User> members = new ArrayList<>();
}
