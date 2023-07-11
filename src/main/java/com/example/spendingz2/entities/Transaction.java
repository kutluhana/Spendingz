package com.example.spendingz2.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.ZonedDateTime;

@Entity
@Table(name="transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long tid;
    String product;
    double price;
    ZonedDateTime date = ZonedDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uid",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;
}
