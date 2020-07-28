package com.websocket.club.respository;

import com.websocket.club.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, Integer> {
    Role save(Role role);
    List<Role> findAll();
    Role getById(Long id);
    void deleteById(Long id);
    int update(Role role);
}
