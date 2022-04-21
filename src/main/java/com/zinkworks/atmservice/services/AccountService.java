package com.zinkworks.atmservice.services;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.zinkworks.atmservice.interfaces.AccountRepository;
import com.zinkworks.atmservice.models.Account;
import com.zinkworks.atmservice.models.Atm;
import com.zinkworks.atmservice.models.WithdrawResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final Atm atm = new Atm(1500, 10, 30, 30, 20);

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Atm getAtm() {
        return atm;
    }

    public MappingJacksonValue getAccountByAccountNumber(int accountNumber, int pin) {

        SimpleBeanPropertyFilter incorrectPinFilter =
                SimpleBeanPropertyFilter.serializeAllExcept("pin", "openingBalance", "overdraft");

        SimpleBeanPropertyFilter correctPinFilter =
                SimpleBeanPropertyFilter.serializeAll();

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("accountFilter", incorrectPinFilter);

        FilterProvider noFilterProvider = new SimpleFilterProvider()
                .addFilter("accountFilter", correctPinFilter);

        Account account = accountRepository.findByAccountNumber(accountNumber);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(account);

        if (account.getAccountNumber() == accountNumber && account.getPin() == pin) {
            mappingJacksonValue.setFilters(noFilterProvider);
        }
        else {
            mappingJacksonValue.setFilters(filterProvider);
        }
        return mappingJacksonValue;
    }

    @Transactional
    public WithdrawResponse updateBalance(int accountNumber, int pin, int amount) {

        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account.getPin() == pin && account.getOpeningBalance() - amount >= 0
                && atm.getBalance() - amount >= 0) {

            account.setOpeningBalance(account.getOpeningBalance() - amount);
            atm.setBalance(atm.getBalance() - amount);
            return new WithdrawResponse(amount, accountNumber,
                    account.getOpeningBalance(),"Successfully Withdrew " + amount + " Euro");
        }
        else if (account.getPin() != pin) {
            return new WithdrawResponse(amount, accountNumber,
                    account.getOpeningBalance(), "Incorrect Pin");
        }
        else if (account.getOpeningBalance() - amount < 0) {
            return new WithdrawResponse(amount, accountNumber,
                    account.getOpeningBalance(), "Your Account has insufficient Funds");
        }
        else {
            return new WithdrawResponse(amount, accountNumber,
                    account.getOpeningBalance(), "The ATM has insufficient Funds");
        }
    }

}
