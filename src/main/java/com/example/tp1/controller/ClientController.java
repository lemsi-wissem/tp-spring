package com.example.tp1.controller;

import com.example.tp1.model.Client;
import com.example.tp1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    @RequestMapping("/client/addClient")
    public String addClient(Model model) {
        Client client = new Client();
        model.addAttribute("clientForm", client);
        return "new_client";
    }

    @PostMapping("/client/save")
    public String saveClient(@ModelAttribute("clientForm") Client client) {
        clientService.saveClient(client);
        return "redirect:/clients/all";
    }

    @GetMapping("/clients/all")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients_list";
    }

    @GetMapping("/client/update/{id}")
    public String updateClient(@PathVariable(value = "id") Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("clientForm", client);
        return "update_client";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable(value = "id") Long id) {
        clientService.deleteClientById(id);
        return "redirect:/clients/all";
    }
}
