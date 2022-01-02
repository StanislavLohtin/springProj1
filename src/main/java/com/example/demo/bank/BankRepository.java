package com.example.demo.bank;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<BankDAO, Long> {

    Optional<BankDAO> findBankDAOByName(String name);
}
