package com.websocket.club.service;


import com.websocket.club.model.Account;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        return (a1.getBalance().subtract(a2.getBalance())).intValue();
    }
}
