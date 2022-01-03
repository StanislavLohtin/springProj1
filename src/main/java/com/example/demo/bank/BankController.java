package com.example.demo.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/banks")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public List<Bank> getBanks() {
        return bankService.getAll();
    }

    @PostMapping
    public void addBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
    }

    @DeleteMapping(path = "{bankId}")
    public void deleteBank(@PathVariable("bankId") Long id) {
        bankService.deleteBank(id);
    }

    @PutMapping
    public void updateBank(@RequestBody Bank bank) {
        bankService.updateBank(bank);
    }

}
