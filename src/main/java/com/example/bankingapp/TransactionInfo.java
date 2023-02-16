package com.example.bankingapp;

public class TransactionInfo {
    private final TransactionType transactionType;
    private final TransactionState transactionState;
    private final ReasonForRejectionOfTransfer reasonForRejectionOfTransfer;
    private final Client client;
    private final double amount;
    private final double actualBalance;

    public TransactionInfo(TransactionType transactionType, TransactionState transactionState, ReasonForRejectionOfTransfer reasonForRejectionOfTransfer, Client client, double amount, double actualBalance) {
        this.transactionType = transactionType;
        this.transactionState = transactionState;
        this.reasonForRejectionOfTransfer = reasonForRejectionOfTransfer;
        this.client = client;
        this.amount = amount;
        this.actualBalance = actualBalance;
    }

    @Override
    public String toString() {
        return "TransactionInfo{" +
                "transactionType=" + transactionType +
                ", transactionState=" + transactionState +
                ", reasonForRejectionOfTransfer=" + reasonForRejectionOfTransfer +
                ", client=" + client +
                ", amount=" + amount +
                ", actualBalance=" + actualBalance +
                '}';
    }
}
