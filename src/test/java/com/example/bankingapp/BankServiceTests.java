package com.example.bankingapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BankServiceTests {
    @Mock
    private TransactionStorage transactionStorage;
    @Mock
    private ClientStorage clientStorage;
    @InjectMocks
    private BankService bankService;

    @Test
    void registerClient() {
        Client client = bankService.registerClient(500);
        assertThat(client).isNotNull();
        assertThat(client.getBalance()).isEqualTo(500);
    }
}
