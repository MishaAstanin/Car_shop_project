package com.example.cardbproject.services;

import com.example.cardbproject.entities.Client;
import com.example.cardbproject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(int id_client) {
        return clientRepository.findById(id_client).orElse(null);
    }


    public Client add(Client client) {
        return clientRepository.save(client);
    }

    public void delete(int id_client) {
        clientRepository.deleteById(id_client);
    }
}
