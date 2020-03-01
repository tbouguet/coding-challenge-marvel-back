package com.coding.challenge.marvel.services.member;

import com.coding.challenge.marvel.exception.MemberPresentException;
import com.coding.challenge.marvel.models.Member;

import java.util.List;

public interface MemberService {

    /**
     * Get all members
     * @return
     */
    List<Member> getMembers();

    /**
     * Add a member
     * @param member
     */
    List<Member> addMember(Member member) throws MemberPresentException;

    /**
     * Delete member
     * @param index
     */
    List<Member> deleteMember(String index);
}
