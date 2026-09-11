package com.example.tp;

public interface PaymentMethod {
    boolean pay(double amount);
    boolean refund(double amount);
    String getName();
}