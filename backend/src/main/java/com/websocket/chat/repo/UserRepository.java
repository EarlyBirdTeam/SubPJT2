package com.websocket.chat.repo;

import java.util.Optional;
import com.websocket.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByNickname(String nickname);
    Optional<User> findUserByEmailAndPassword(String email, String password);
    
    void deleteByEmail(String email);
}
