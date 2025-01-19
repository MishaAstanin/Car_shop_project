package com.example.cardbproject.controllers;

import com.example.cardbproject.entities.Client;
import com.example.cardbproject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public String getAllClients(Model model) {
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/{id_client}")
    public @ResponseBody Client getClient(@PathVariable Integer id_client) {
        return clientService.getById(id_client);
    }

    @GetMapping("/add")
    public String addClient(Model model) {
        model.addAttribute("client", new Client());
        return "create-client";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client) {
        try {
            if (Objects.equals(client.getPatronymic(), "")) {
                client.setPatronymic(null);
            }
            if (Objects.equals(client.getEmail(), "")) {
                client.setEmail(null);
            }
            clientService.add(client);
            return "redirect:/clients/all";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            String[] parts = errorMessage.split("[\\[\\]]");
            System.out.println(parts[1]);
            return "redirect:/clients/fail";
        }
    }

    @GetMapping("/fail")
    public String failClient(Model model) {
        model.addAttribute("error", "клиента");
        return "fail-create-client";
    }

    @PostMapping("/delete-client/{id_client}")
    public String deleteClient(@PathVariable Integer id_client) {
        clientService.delete(id_client);
        return "redirect:/clients/all";
    }
}
