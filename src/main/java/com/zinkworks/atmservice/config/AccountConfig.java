package com.zinkworks.atmservice.config;

import com.zinkworks.atmservice.models.Account;
import com.zinkworks.atmservice.interfaces.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository){
        return  args -> {
            Account accountOne = new Account(1,123456789, 1234, 800, 200);
            Account accountTwo = new Account(2,987654321, 4321, 1230, 150);
            repository.saveAll(List.of(accountOne, accountTwo));
        };
    }

}
