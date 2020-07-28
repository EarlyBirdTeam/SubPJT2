package com.websocket.club.controller;


import com.websocket.club.model.Account;
import com.websocket.club.model.Member;
import com.websocket.club.service.AccountService;
import com.websocket.club.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value={"/accounts"})
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private MemberService memberService;


    //{prefix}/accounts POST
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Account createAccount(@RequestParam("playerName") String playerName, @RequestBody Account account){
        Member member = memberService.getMemberByName(playerName);
        account.setMember(member);
        return accountService.save(account);
    }

    //{prefix}/accounts DELETE
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable("id") Integer id){
        String msg=null;
        boolean isSuccess=accountService.deleteAccountById(id);
        if(isSuccess){
            msg="the account is successfully deleted";
        }else {
            msg="failure to delete account";
        }
        return msg;
    }

    //{prefix}/accounts GET
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") Integer id){
        Account account=accountService.getAccountById(id);
        return account;
    }
    //{prefix}/accounts GET
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<BigDecimal> getBalanceAll(){
        List<BigDecimal> balanceAll = accountService.getBalanceOnly();
        return balanceAll;
    }

    //{prefix}/accounts GET
    @RequestMapping(value = "/balasc",method = RequestMethod.GET)
    public List<Account> getBalance(){
        List<Account> accountBalanceAsc = accountService.getAccountBalanceAsc();
        return accountBalanceAsc;
    }
}
