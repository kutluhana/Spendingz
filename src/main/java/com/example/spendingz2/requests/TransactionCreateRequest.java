package com.example.spendingz2.requests;

import lombok.Data;


@Data
public class TransactionCreateRequest {
    String product;
    double price;
    Long uid;
}
