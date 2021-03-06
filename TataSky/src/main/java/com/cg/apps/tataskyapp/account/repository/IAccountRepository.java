package com.cg.apps.tataskyapp.account.repository;
/*
 Account Repository Class
 */

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.apps.tataskyapp.account.entities.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {



	@Query("Select count(a.accountId) from Account a where a.registeredDate between :stdt and :enddt ")
	int countCreatedAccountsInPeriod(@Param("stdt") LocalDate startDate, @Param("enddt") LocalDate endDate);


//  /**
//   * finds count of accounts in the application
//   */
	@Query(value = "select count(a.accountId) from Account a")
	int countAccounts();


}
