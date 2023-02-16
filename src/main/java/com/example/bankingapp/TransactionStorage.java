package com.example.bankingapp;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionStorage {
    private final List<TransactionInfo> transactionInfoList = new ArrayList<>();

    public TransactionStorage() {
        transactionInfoList.add(new TransactionInfo(TransactionType.OUTGOING, TransactionState.ACCEPTED, null, new Client("c005", 5000), 1000, 4000));
        transactionInfoList.add(new TransactionInfo(TransactionType.OUTGOING, TransactionState.REJECTED, ReasonForRejectionOfTransfer.GIVEN_AMOUNT_IS_GREATER_THAN_ACTUAL_USER_BALANCE, new Client("c006", 6000), 12000, 6000));
        transactionInfoList.add(new TransactionInfo(TransactionType.INCOMING, TransactionState.ACCEPTED, null, new Client("c007", 7000),50000, 57000));
    }

    public void addEntry(TransactionInfo transactionInfo) {
        transactionInfoList.add(transactionInfo);
    }
}
