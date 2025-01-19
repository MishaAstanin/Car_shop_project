package com.example.cardbproject.controllers;

import com.example.cardbproject.DTO.ViewContractDto;
import com.example.cardbproject.entities.Contract;
import com.example.cardbproject.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/all")
    public String getAllContracts(Model model) {
        List<Contract> contracts = contractService.getAll();
        model.addAttribute("contracts", contracts);
        return "contracts";
    }

    @GetMapping("/{number}")
    public @ResponseBody Contract getContract(@PathVariable Integer number) {
        return contractService.getByNumber(number);
    }

    @GetMapping("/add/{id_car}")
    public String addContract(@PathVariable Integer id_car, Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("id_car", id_car);
        return "create-contract";
    }

    @PostMapping("/add/{id_car}")
    public String addContract(@ModelAttribute Contract contract, @PathVariable Integer id_car) {
        try {
            if (Objects.equals(contract.getCardNumber(), "")) {
                contract.setCardNumber(null);
            }
            contract.setCarId(id_car);
            contractService.add(contract);
            return "redirect:/contracts/all";
        } catch (Exception e) {
            return "redirect:/contracts/fail";
        }
    }

    @GetMapping("/fail")
    public String failContract() {
        return "fail-create-contract";
    }

    @PostMapping("/delete-contract/{number}")
    public String deleteContract(@PathVariable Integer number) {
        contractService.delete(number);
        return "redirect:/contracts/all";
    }

    @GetMapping("/warranty-repair")
    public String getViewContract(Model model) {
        List<ViewContractDto> viewContracts = contractService.getViewContracts();
        model.addAttribute("viewContracts", viewContracts);
        return "contract-warranty-repair";
    }
}
