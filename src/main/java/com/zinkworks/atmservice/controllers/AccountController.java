package com.zinkworks.atmservice.controllers;

import com.zinkworks.atmservice.services.AccountService;
import com.zinkworks.atmservice.models.Atm;
import com.zinkworks.atmservice.models.WithdrawRequest;
import com.zinkworks.atmservice.models.WithdrawResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/atm")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/balance")
    public Atm getAtm() {
        return accountService.getAtm();
    }

    @GetMapping("/accounts/{accountNumber}/{pin}")
    public MappingJacksonValue getAccountByAccountNumber(@PathVariable int accountNumber, @PathVariable int pin) {
        return accountService.getAccountByAccountNumber(accountNumber, pin);
    }

    @PutMapping(path = "/accounts/{accountNumber}")
    public WithdrawResponse withdrawMoney(
            @PathVariable int accountNumber,
            @RequestBody WithdrawRequest withdrawRequest) {

       return accountService.updateBalance(accountNumber, withdrawRequest.getPin(), withdrawRequest.getAmount());

    }

}
