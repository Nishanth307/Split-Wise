package com.scaler.splitwise.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
      private Long From;
      private Long To;
      private Double amount;
}
