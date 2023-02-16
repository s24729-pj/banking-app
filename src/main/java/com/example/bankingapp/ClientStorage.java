package com.example.bankingapp;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientStorage {
    private final List<Client> clientList = new ArrayList<>();

    public ClientStorage() {
        clientList.add(new Client("c001", 10000));
        clientList.add(new Client("c002", 200000));
        clientList.add(new Client("c003", 3000000));
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void addClientToList(Client client) {
        clientList.add(client);
    }
}
