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


    public List<BankDAO> getAll() {
        return bankRepository.findAll();
    }

    public void addBank(BankDAO bankDAO) {
        Optional<BankDAO> bankDAOByName = bankRepository.findBankDAOByName(bankDAO.getName());
        if (bankDAOByName.isPresent()) {
            throw new BankAlreadyExistsException();
        }
        bankRepository.save(bankDAO);
    }

    public void deleteBank(Long id) {
        Optional<BankDAO> bankDAOById = bankRepository.findById(id);
        if (!bankDAOById.isPresent()) {
            throw new BankDoesNotExistException();
        }
        bankRepository.delete(bankDAOById.get());
    }

    public void updateBank(BankDAO bankDAO) {
        Optional<BankDAO> bankDAOById = bankRepository.findById(bankDAO.getId());
        if (!bankDAOById.isPresent()) {
            throw new BankDoesNotExistException();
        }
        BankDAO bankFromDb = bankDAOById.get();
        bankFromDb.setCountry(bankDAO.getCountry());
        bankFromDb.setName(bankDAO.getName());
        bankFromDb.setPhone(bankDAO.getPhone());
        bankFromDb.setRank(bankDAO.getRank());
        bankRepository.save(bankFromDb);
    }
}
