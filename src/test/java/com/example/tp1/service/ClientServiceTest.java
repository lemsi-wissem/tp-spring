package com.example.tp1.service;

import com.example.tp1.model.Client;
import com.example.tp1.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveClient_ValidClient_ReturnsSavedClient() {
        // Arrange
        Client client = new Client();
        when(clientRepository.save(client)).thenReturn(client);

        // Act
        Client savedClient = clientService.saveClient(client);

        // Assert
        assertEquals(client, savedClient);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void deleteClientById_ValidId_ReturnsNothing() {
        // Arrange
        Long id = 1L;
        doNothing().when(clientRepository).deleteById(id);

        // Act
        clientService.deleteClientById(id);

        // Assert
        verify(clientRepository, times(1)).deleteById(id);
    }

    @Test
    public void getClientById() {
        // Arrange
        Long id = 1L;
        Client client = new Client();
        when(clientRepository.findById(id)).thenReturn(java.util.Optional.of(client));

        // Act
        Client foundClient = clientService.getClientById(id);

        // Assert
        assertEquals(client, foundClient);
        verify(clientRepository, times(1)).findById(id);
    }

    @Test
    public void updateClient() {
        // Arrange
        Client client = new Client();
        when(clientRepository.save(client)).thenReturn(client);

        // Act
        Client updatedClient = clientService.updateClient(client);

        // Assert
        assertEquals(client, updatedClient);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    @DisplayName("Should return all clients when getAllClients is called")
    void shouldReturnAllClientsWhenGetAllClientsIsCalled() {
        List<Client> clients = Arrays.asList(new Client(), new Client());
        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> returnedClients = clientService.getAllClients();

        assertEquals(clients, returnedClients);
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return empty list when no clients exist")
    void shouldReturnEmptyListWhenNoClientsExist() {
        when(clientRepository.findAll()).thenReturn(List.of());

        List<Client> returnedClients = clientService.getAllClients();

        assertEquals(0, returnedClients.size());
        verify(clientRepository, times(1)).findAll();
    }

}