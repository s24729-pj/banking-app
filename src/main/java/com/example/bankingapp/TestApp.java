package com.example.bankingapp;

import org.springframework.stereotype.Component;

@Component
public class TestApp {
    public TestApp(BankService bankService) {
        // Client registration
        System.out.println("All clients before adding a client: " + bankService.getAllClients());
        System.out.println("Registered client: " + bankService.registerClient(20000));
        System.out.println("All clients after adding a client: " + bankService.getAllClients());

        // Outgoing transfer order
        System.out.println("New outgoing transfer: " + bankService.outgoingTransfer("c004", 3000));
        System.out.println("All clients after outgoing transfer from client with ID c004 (-3000): " + bankService.getAllClients());

        // Incoming transfer order
        System.out.println("New incoming transfer: " + bankService.incomingTransfer("c004", 7000));
        System.out.println("All clients after incoming transfer to client with ID c004 (+7000): " + bankService.getAllClients());

        // Displaying client info
        System.out.print("Showing information about client with ID c001: ");
        bankService.showClientInfo("c001");
        System.out.println();
    }
}
