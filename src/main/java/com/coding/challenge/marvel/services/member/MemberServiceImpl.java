package com.coding.challenge.marvel.services.member;

import com.coding.challenge.marvel.exception.MemberPresentException;
import com.coding.challenge.marvel.models.Character;
import com.coding.challenge.marvel.models.Member;
import com.coding.challenge.marvel.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMembers(){
        return memberRepository.getMembers();
    }

    public List<Member> addMember(Member member) throws MemberPresentException {
        return memberRepository.addMember(member);
    }

    public List<Member> deleteMember(String index){
        return memberRepository.deleteMember(index);
    }

}
