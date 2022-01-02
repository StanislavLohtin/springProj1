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
    public List<BankDAO> getBanks() {
        return bankService.getAll();
    }

    @PostMapping
    public void addBank(@RequestBody BankDAO bankDAO) {
        bankService.addBank(bankDAO);
    }

    @DeleteMapping(path = "{bankId}")
    public void deleteBank(@PathVariable("bankId") Long id) {
        bankService.deleteBank(id);
    }

    @PutMapping
    public void updateBank(@RequestBody BankDAO bankDAO) {
        bankService.updateBank(bankDAO);
    }

}
