package com.scaler.splitwise.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Expense extends BaseModel{
      private String description;
      private Double totalAmount;
      private Date createdOn;

      @ManyToOne
      private Group group;

      @ManyToMany
      private List<User> users = new ArrayList<>();

      @OneToMany
      @ElementCollection
      private List<UserExpense> paidBy = new ArrayList<>();

      @OneToMany
      @ElementCollection
      private List<UserExpense> owedBy = new ArrayList<>();
}
