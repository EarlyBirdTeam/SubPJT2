package com.websocket.club.respository;



import com.websocket.chat.model.User;
import com.websocket.club.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountDao extends JpaRepository<Account,Integer> {
    List<Account> findAll();
    Account save(Account account);
    boolean delete(Integer id);
    Account findAccountById(int id);
}
