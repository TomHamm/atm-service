package com.zinkworks.atmservice.interfaces;

import com.zinkworks.atmservice.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.accountNumber = ?1")
    Account findByAccountNumber(int accountNumber);

}
