package com.scaler.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UserExpense extends BaseModel{
      private Double amount;
      @ManyToOne
      private Expense expense;
      @ManyToOne
      private User user;
      @Enumerated
      private ExpenseType type;
}
