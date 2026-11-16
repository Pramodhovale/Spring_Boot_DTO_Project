package com.account.repositry;

import com.account.entity.Account;
import com.account.entity.projection.AccountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
   public AccountProjection findAccountProjectedByAccountId(Integer  accountId);
}
