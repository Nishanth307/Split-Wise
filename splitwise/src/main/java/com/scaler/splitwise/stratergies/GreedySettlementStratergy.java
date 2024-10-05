package com.scaler.splitwise.stratergies;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

import com.scaler.splitwise.dtos.Transaction;
import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.models.UserExpense;


public class GreedySettlementStratergy implements SettlementStrategy{

      @Override
      public List<Transaction> settleup(List<Expense> expenses) {
            Map<Long,Double> balances = calculateBalances(expenses);
            TreeSet<Pair<Long,Double>> heap = new TreeSet<>((expense1,expense2)->(int)(expense1.getSecond()-expense2.getSecond()));
            for (Map.Entry<Long, Double> balance:balances.entrySet()) {
                  heap.add(Pair.of(balance.getKey(), balance.getValue()));
            }
            List<Transaction> transactions = new ArrayList<>();
            while (heap.size()>1) {
                  //find the smallest pair - minimum value
                  Pair<Long,Double> smallestPair = heap.first();
                  //find the largest pair  - max val
                  Pair<Long,Double> largestPair = heap.last();
                  //pay from minimum to maximum
                  Transaction transaction = Transaction
                                          .builder()
                                          .From(largestPair.getFirst())
                                          .To(smallestPair.getFirst())
                                          .amount(smallestPair.getSecond())
                                          .build();
                  heap.remove(largestPair);
                  heap.remove(smallestPair);
                  //if the amount is not exact
                  heap.add(Pair.of(smallestPair.getFirst(), smallestPair.getSecond()+largestPair.getSecond()));
                  transactions.add(transaction);
            }
            return transactions;
      }

      private Map<Long,Double> calculateBalances(List<Expense> expenses){
            Map<Long,Double> balances = new HashMap<>();
            for (Expense expense:expenses){
                  for (UserExpense userExpense:expense.getOwedBy()){
                        User user = userExpense.getUser();
                        if (!balances.containsKey(user.getId())){
                              balances.put(user.getId(), 0.0);
                        }
                        balances.put(user.getId(), balances.get(user.getId())+userExpense.getAmount());
                  }

                  for (UserExpense userExpense:expense.getPaidBy()){
                        User user = userExpense.getUser();
                        if (!balances.containsKey(user.getId())){
                              balances.put(user.getId(), 0.0);
                        }
                        balances.put(user.getId(), balances.get(user.getId())-userExpense.getAmount());
                  }
            }
            return balances;
      }
      
}
