package com.zinkworks.atmservice.interfaces;

import com.zinkworks.atmservice.models.Account;
import com.zinkworks.atmservice.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.converter.json.MappingJacksonValue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void whenFindByAccountNumberIsCalledWithValidAccountNumber_thenTheExpectedAccountIsReturned() {
        // given
        Account account = new Account(123456789, 1234, 800, 200);
        accountRepository.save(account);

        //when
        Account expectedAccount = accountRepository.findByAccountNumber(123456789);

        //then
        assertThat(account.getAccountNumber()).isEqualTo(expectedAccount.getAccountNumber());
        assertThat(account.getPin()).isEqualTo(expectedAccount.getPin());
        assertThat(account.getOpeningBalance()).isEqualTo(expectedAccount.getOpeningBalance());
        assertThat(account.getOverdraft()).isEqualTo(expectedAccount.getOverdraft());
    }

    @Test
    void whenFindByAccountNumberIsCalledWithInvalidAccountNumber_thenNoAccountIsReturned() {
        // given
        int accountNumber = 987654321;

        //when
        Account expectedAccount = accountRepository.findByAccountNumber(accountNumber);

        //then
        assertThat(expectedAccount).isNull();
    }
}