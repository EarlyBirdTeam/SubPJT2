package com.websocket.club.respository;



import com.websocket.chat.model.User;
import com.websocket.club.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberDao extends JpaRepository<Member, Integer> {
    Member save(Member member, String clubName);
    Member updateMemberEmail(Member member);

    List<Member> findAllMemberAndClub();
    Member findMemberById(Integer Id);
    Member findMemberByName(String playerName);

    boolean delete(Integer id);
}
