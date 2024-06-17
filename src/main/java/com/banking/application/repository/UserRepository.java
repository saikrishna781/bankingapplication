package com.banking.application.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository {

    // Simulate database operation
    public Mono<Void> updatePassword(String username, String newLoginPassword, String newTransactionPassword) {
        // In a real application, update the database here
        System.out.println("Updating passwords for user: " + username);
        System.out.println("New login password: " + newLoginPassword);
        System.out.println("New transaction password: " + newTransactionPassword);
        return Mono.empty();
    }
}

