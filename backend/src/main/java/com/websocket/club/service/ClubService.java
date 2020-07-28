package com.websocket.club.service;

import com.websocket.club.model.Club;
import com.websocket.club.respository.ClubDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubDao clubDao;

    public Club save(Club club){return clubDao.save(club);}
    public Club getClubById(Integer id){return clubDao.findClubById(id);}
    public Club getClubByName(String clubName){return clubDao.findClubByName(clubName);}
    public List<Club> getClubsEager(){return clubDao.findAll();}
    public boolean deleteDepartment(Integer id){return clubDao.delete(id);}
    public boolean updateDesc(Club club){return clubDao.updateDesc(club);}
}

