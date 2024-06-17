package com.banking.application.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class AccountController {
//
//    @GetMapping("/")
//    public String accountStatement() {
//        return "account-statement";
//    }
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private List<Transaction> transactions = new ArrayList<>();

    // Get all transactions
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    // Get a specific transaction by index
    @GetMapping("/transactions/{index}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable int index) {
        if (index >= 0 && index < transactions.size()) {
            return ResponseEntity.ok(transactions.get(index));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new transaction
    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        transactions.add(transaction);
        return ResponseEntity.ok(transaction);
    }

    // Update an existing transaction by index
    @PutMapping("/transactions/{index}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable int index, @RequestBody Transaction updatedTransaction) {
        if (index >= 0 && index < transactions.size()) {
            transactions.set(index, updatedTransaction);
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a transaction by index
    @DeleteMapping("/transactions/{index}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Nested static Transaction class
    public static class Transaction {
        private String date;
        private String type;
        private double amount;
        private String description;

        // Constructor
        public Transaction(String date, String type, double amount, String description) {
            this.date = date;
            this.type = type;
            this.amount = amount;
            this.description = description;
        }

        // Default constructor
        public Transaction() {
        }

        // Getters and Setters
        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
