package com.example.bankingapp;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankService {
    private final TransactionStorage transactionStorage;
    private final ClientStorage clientStorage;

    public BankService(TransactionStorage transactionStorage, ClientStorage clientStorage) {
        this.transactionStorage = transactionStorage;
        this.clientStorage = clientStorage;
    }

    public Client registerClient(double initialBalance) {
        Client client = new Client(generateNewClientIdentifier(), initialBalance);
        clientStorage.addClientToList(client);
        return client;
    }

    public TransactionInfo outgoingTransfer(String clientId, double amount) {
        Client client = findClientById(clientId);
        TransactionInfo transactionInfo;

        if(client == null) {
            transactionInfo = new TransactionInfo(TransactionType.OUTGOING, TransactionState.REJECTED, ReasonForRejectionOfTransfer.USER_WITH_GIVEN_ID_DOES_NOT_EXIST, client, amount, 0);
        } else if(amount > client.getBalance()) {
            transactionInfo = new TransactionInfo(TransactionType.OUTGOING, TransactionState.REJECTED, ReasonForRejectionOfTransfer.GIVEN_AMOUNT_IS_GREATER_THAN_ACTUAL_USER_BALANCE, client, amount, client.getBalance());
        } else {
            client.subtractFromBalance(amount);
            transactionInfo = new TransactionInfo(TransactionType.OUTGOING, TransactionState.ACCEPTED, null, client, amount, client.getBalance());
        }
        transactionStorage.addEntry(transactionInfo);
        return transactionInfo;
    }

    public TransactionInfo incomingTransfer(String clientId, double amount) {
        Client client = findClientById(clientId);
        TransactionInfo transactionInfo;

        if(client == null) {
            transactionInfo = new TransactionInfo(TransactionType.INCOMING, TransactionState.REJECTED, ReasonForRejectionOfTransfer.USER_WITH_GIVEN_ID_DOES_NOT_EXIST, client, amount, 0);
        } else {
            client.addToBalance(amount);
            transactionInfo = new TransactionInfo(TransactionType.INCOMING, TransactionState.ACCEPTED, null, client, amount, client.getBalance());
        }
        transactionStorage.addEntry(transactionInfo);
        return transactionInfo;
    }

    public void showClientInfo(String clientId) {
        Client client = findClientById(clientId);
        System.out.print(client);
    }

    private String generateNewClientIdentifier() {
        int numberOfRegisteredClients = getAllClients().size();
        return String.format("c%03d", numberOfRegisteredClients + 1);
    }

    private Client findClientById(String clientId) {
        for (Client client : clientStorage.getClientList()) {
            if(client.getId().equals(clientId)) {
                return client;
            }
        }
        return null;
    }

    public List<Client> getAllClients() {
        return clientStorage.getClientList();
    }
}
