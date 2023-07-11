package com.example.spendingz2.repos;

import com.example.spendingz2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
