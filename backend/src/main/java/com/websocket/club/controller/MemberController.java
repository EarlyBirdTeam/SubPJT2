package com.websocket.club.controller;


import com.websocket.club.model.Club;
import com.websocket.club.model.Member;
import com.websocket.club.service.ClubService;
import com.websocket.club.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value={"/players","play"})
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private ClubService clubService;


    @RequestMapping(value = "",method = RequestMethod.POST)
    public Member createMember(@RequestParam("clubName") String clubName, @RequestBody Member member){
        String msg;
        Club club= clubService.getClubByName(clubName);
        Member p= memberService.save(member, club.getName());
        return p;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
    public Member updateMemberEmail(@PathVariable("id") Integer id, @RequestParam("email") String email){
        Member p= memberService.getMemberById(id);
        p.setEmail(email);
        return memberService.updateEmployeeEmail(p);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Member> getMembersAndClub(){return memberService.getMembersAndClub();}

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Member getMemberByName(@RequestParam("playerName") String mamberName){
        Member member= memberService.getMemberByName(mamberName);
        return member;
    }

    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public String deleteMember(@PathVariable("id") Integer id){
        String msg=null;
        boolean isSuccess= memberService.deleteMember(id);
        if(isSuccess){
            msg="the player is successfully deleted";
        }else{
            msg="failure to delete player";
        }
        return msg;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Member getPlayerById(@PathVariable("id") Integer Id){
        Member member= memberService.getMemberById(Id);
        return member;
    }

}
