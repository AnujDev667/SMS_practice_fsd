package com.designpatterns.factory;

public interface Payment {
    void processPayment(String accountNumber, double amount, TransactionType type);
}
