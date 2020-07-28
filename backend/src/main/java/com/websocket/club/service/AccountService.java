package com.websocket.club.service;


import com.websocket.club.model.Account;
import com.websocket.club.respository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    public AccountDao accountDao;

    public Account getAccountById(Integer id){return accountDao.findAccountById(id);}
    public Account save(Account account){return accountDao.save(account);}
    public boolean deleteAccountById(Integer id){return accountDao.delete(id);}

    public List<BigDecimal> getBalanceOnly(){
        List<Account> allAccounts = accountDao.findAll();
        List<BigDecimal> balance = allAccounts.stream().map(a -> a.getBalance()).collect(Collectors.toList());
        return balance;
    }

    public List<Account> getAccountBalanceAsc(){
        List<Account> allAccounts = accountDao.findAll();
        Comparator<Account> c=(a1,a2)->(a1.getBalance().subtract(a2.getBalance()).intValue());
        Collections.sort(allAccounts,c);
        return allAccounts;
    }
}
