package com.designpatterns.factory;

public class UpiPayment implements Payment {
    @Override
    public void processPayment(String accountNumber, double amount, TransactionType type) {
        System.out.println("Processing UPI payment for account: " + accountNumber);
        System.out.println("Amount: " + amount);
        System.out.println("Transaction type: " + type);
    }
}
