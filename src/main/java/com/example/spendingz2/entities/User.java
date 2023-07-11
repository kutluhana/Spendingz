package com.example.spendingz2.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name= "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long uid;
    String email;
    String password;
}
