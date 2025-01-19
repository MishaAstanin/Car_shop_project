package com.example.cardbproject.repositories;

import com.example.cardbproject.DTO.ViewContractDto;
import com.example.cardbproject.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT * FROM contract_with_warranty_repair", nativeQuery = true)
    List<ViewContractDto> getContractWithWarrantyRepair();
}
