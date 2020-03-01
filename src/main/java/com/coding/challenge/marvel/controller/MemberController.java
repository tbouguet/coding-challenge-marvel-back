package com.coding.challenge.marvel.controller;

import com.coding.challenge.marvel.exception.MemberPresentException;
import com.coding.challenge.marvel.models.Member;
import com.coding.challenge.marvel.services.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/members")
@CrossOrigin
public class    MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getMembers(){
        return memberService.getMembers();
    }

    @PostMapping
    public List<Member> postMember(@RequestBody Member member) throws MemberPresentException {
        return memberService.addMember(member);
    }

    @DeleteMapping("/{id}")
    public List<Member> deleteMember(@PathVariable("id") String id) {
        return memberService.deleteMember(id);
    }
}