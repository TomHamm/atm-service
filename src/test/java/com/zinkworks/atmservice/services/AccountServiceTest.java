package com.zinkworks.atmservice.services;

import com.zinkworks.atmservice.interfaces.AccountRepository;
import com.zinkworks.atmservice.models.Account;
import com.zinkworks.atmservice.models.Atm;
import com.zinkworks.atmservice.models.WithdrawResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.json.MappingJacksonValue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    private AutoCloseable autoCloseable;
    private AccountService accountServiceUnderTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        accountServiceUnderTest = new AccountService(accountRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAtm() {
        Atm atm = accountServiceUnderTest.getAtm();
        assertThat(atm.getBalance()).isEqualTo(1500);
    }

    @Test
    void whenGetAccountByAccountNumberIsCalledWithValidPinAndAccountNumber_thenExpectedAccountIsReturned() {
        Account expectedAccount = new Account(123456789, 1234, 800, 200);
        when(accountRepository.findByAccountNumber(123456789)).thenReturn(expectedAccount);
        MappingJacksonValue mappingJacksonValue = accountServiceUnderTest.getAccountByAccountNumber(123456789, 1234);
        assertThat(mappingJacksonValue.getValue().equals(expectedAccount));
    }

    @Test
    void whenUpdateBalanceIsCalledWithValidParameters_thenUsersAccountisUpdatedAndSuccessfulWithdrawResposeIsReturned() {
        Account expectedAccount = new Account(123456789, 1234, 800, 200);
        when(accountRepository.findByAccountNumber(123456789)).thenReturn(expectedAccount);
        WithdrawResponse withdrawResponse = accountServiceUnderTest.updateBalance(123456789, 1234, 200);
        assertThat(withdrawResponse.getCurrentBalance()).isEqualTo(600);
        assertThat(withdrawResponse.getMessage()).isEqualTo("Successfully Withdrew 200 Euro");
    }

    @Test
    void whenUpdateBalanceIsCalledWithInsufficientAccountFunds_thenUsersAccountisNotUpdatedAndInsufficientUserFundsWithdrawResposeIsReturned() {
        Account expectedAccount = new Account(123456789, 1234, 800, 200);
        when(accountRepository.findByAccountNumber(123456789)).thenReturn(expectedAccount);
        WithdrawResponse withdrawResponse = accountServiceUnderTest.updateBalance(123456789, 1234, 900);
        assertThat(withdrawResponse.getCurrentBalance()).isEqualTo(800);
        assertThat(withdrawResponse.getMessage()).isEqualTo("Your Account has insufficient Funds");
    }

    @Test
    void whenUpdateBalanceIsCalledWithInsufficientAtmFunds_thenUsersAccountisNotUpdatedAndInsufficientAtmFundsWithdrawResposeIsReturned() {
        Account expectedAccount = new Account(123456789, 1234, 1800, 200);
        when(accountRepository.findByAccountNumber(123456789)).thenReturn(expectedAccount);
        WithdrawResponse withdrawResponse = accountServiceUnderTest.updateBalance(123456789, 1234, 1600);
        assertThat(withdrawResponse.getCurrentBalance()).isEqualTo(1800);
        assertThat(withdrawResponse.getMessage()).isEqualTo("The ATM has insufficient Funds");
    }

}