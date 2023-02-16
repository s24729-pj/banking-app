package com.example.bankingapp;

public class Client {
    private final String id;
    private double balance;

    public Client(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void subtractFromBalance(double amount) {
        this.balance = balance - amount;
    }

    public void addToBalance(double amount) {
        this.balance = balance + amount;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }
}
