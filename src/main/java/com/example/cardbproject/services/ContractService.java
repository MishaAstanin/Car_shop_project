package com.example.cardbproject.services;

import com.example.cardbproject.DTO.ViewContractDto;
import com.example.cardbproject.entities.Contract;
import com.example.cardbproject.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    public Contract getByNumber(int number) {
        return contractRepository.findById(number).orElse(null);
    }

    public Contract add(Contract contract) {
        return contractRepository.save(contract);
    }

    public void delete(int number) {
        contractRepository.deleteById(number);
    }

    public List<ViewContractDto> getViewContracts() {
        return contractRepository.getContractWithWarrantyRepair();
    }
}
