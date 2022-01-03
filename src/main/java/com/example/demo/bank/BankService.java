package com.example.demo.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }


    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    public void addBank(Bank bank) {
        Optional<Bank> bankByName = bankRepository.findBankByName(bank.getName());
        if (bankByName.isPresent()) {
            throw new BankAlreadyExistsException();
        }
        bankRepository.save(bank);
    }

    public void deleteBank(Long id) {
        Bank bankById = findById(id);
        bankRepository.delete(bankById);
    }

    public void updateBank(Bank bank) {
        Bank bankFromDb = findById(bank.getId());
        bankFromDb.setCountry(bank.getCountry());
        bankFromDb.setName(bank.getName());
        bankFromDb.setPhone(bank.getPhone());
        bankFromDb.setRank(bank.getRank());
        bankRepository.save(bankFromDb);
    }

    private Bank findById(Long id) {
        return bankRepository.findById(id).orElseThrow(BankDoesNotExistException::new);
    }
}
