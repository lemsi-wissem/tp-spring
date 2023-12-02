package com.example.tp1.controller;

import com.example.tp1.model.Client;
import com.example.tp1.service.ClientService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

    private final ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        try {
            return ResponseEntity.ok(clientService.saveClient(client));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(clientService.getClientById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        try {
            return ResponseEntity.ok(clientService.updateClient(client));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Resource> deleteClient(@PathVariable("id") Long id) {
        try {
            clientService.deleteClientById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Client>> getAllClients() {
        try {
            return ResponseEntity.ok(clientService.getAllClients());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
