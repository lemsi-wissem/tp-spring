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

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("clientForm") Client client) {
        clientService.saveClient(client);
        return "redirect:/";
    }
}
