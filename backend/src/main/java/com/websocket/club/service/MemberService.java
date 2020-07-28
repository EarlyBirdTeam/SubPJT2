package com.websocket.club.service;


import com.websocket.club.model.Member;
import com.websocket.club.respository.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public Member save(Member member, String clubName){return memberDao.save(member,clubName);}
    public Member updateEmployeeEmail(Member member){return memberDao.updateMemberEmail(member);}
    public List<Member> getMembersAndClub(){return memberDao.findAllMemberAndClub();}
    public Member getMemberByName(String playerName){return memberDao.findMemberByName(playerName);}
    public boolean deleteMember(Integer id){return memberDao.delete(id);}
    public Member getMemberById(Integer id){return memberDao.findMemberById(id);}
}
