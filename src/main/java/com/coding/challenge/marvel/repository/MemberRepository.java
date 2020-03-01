package com.coding.challenge.marvel.repository;

import com.coding.challenge.marvel.exception.MemberPresentException;
import com.coding.challenge.marvel.models.Member;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * IMPROVE : Use database instead of local list and use spring data
 */

@Repository
public class MemberRepository {
    private List<Member> members = new ArrayList<>();

    public List<Member> getMembers(){
        return members;
    }

    public List<Member> addMember(Member member) throws MemberPresentException {
        if (members.stream().anyMatch(memberList -> StringUtils.equals(memberList.getId(), member.getId()))){
            throw new MemberPresentException("This member is already present");
        }
        members.add(member);
        return members;
    }

    public List<Member> deleteMember(String index){
        members.removeIf(member -> index.equals(member.getId()));
        return members;
    }


}
