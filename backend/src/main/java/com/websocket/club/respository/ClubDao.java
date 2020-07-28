package com.websocket.club.respository;


import com.websocket.chat.model.User;
import com.websocket.club.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClubDao extends JpaRepository<Club, Integer> {
    Club save(Club club);


    Club findClubById(int id);

    Club findClubByName(String clubName);
    //3: lazy join
    //List<Club> getClubsLazy();
    //4: eager join
    List<Club> findAll();

    boolean delete(Integer id);
    boolean updateDesc(Club club);
}
