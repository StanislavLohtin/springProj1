package com.example.demo.bank;

import javax.persistence.*;

@Entity
@Table
public class BankDAO {
    @Id
    @SequenceGenerator(
            name = "bank_sequence",
            sequenceName = "bank_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "bank_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    private String name;

    private String country;

    private String phone;

    private Long rank;

    public BankDAO() {}

    public BankDAO(String name, String country, String phone, Long rank) {
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.rank = rank;
    }

    public BankDAO(Long id, String name, String country, String phone, Long rank) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }
}
