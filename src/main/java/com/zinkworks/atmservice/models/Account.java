package com.zinkworks.atmservice.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;

@Entity
@Table
@JsonFilter("accountFilter")
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private long id;
    private int accountNumber, pin, openingBalance, overdraft;

    public Account() {}

    public Account(long id, int accountNumber, int pin, int openingBalance, int overdraft) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.openingBalance = openingBalance;
        this.overdraft = overdraft;
    }

    public Account(int accountNumber, int pin, int openingBalance, int overdraft) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.openingBalance = openingBalance;
        this.overdraft = overdraft;
    }

    @JsonIgnore
    public long getId() {
        return id;
    }

    @JsonSetter
    public void setId(long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int pin) {
        this.accountNumber = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int an) {
        this.pin = an;
    }

    public int getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(int openingBalance) {
        this.openingBalance = openingBalance;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", accountNumber=" + accountNumber +
                ", pin=" + pin +
                ", openingBalance=" + openingBalance +
                ", overdraft=" + overdraft +
                '}';
    }
}
