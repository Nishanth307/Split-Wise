package com.scaler.splitwise.stratergies;
import java.util.List;

import com.scaler.splitwise.dtos.Transaction;
import com.scaler.splitwise.models.Expense;

public interface SettlementStrategy {
      public List<Transaction> settleup(List<Expense> expense);
}
