package com.example.demo.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BankConfig {

    private final BankRepository bankRepository;

    @Autowired
    public BankConfig(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            BankDAO bank1 = new BankDAO("bank1", "Italy", "+42 (233) 98333", 3L);
            BankDAO bank2 = new BankDAO("bank2", "France", "+32 (233) 25233", 5L);
            List<BankDAO> banks = new ArrayList<>();
            banks.add(bank1);
            banks.add(bank2);
            bankRepository.saveAll(banks);
        };
    }

}
