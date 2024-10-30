package com.lec.ch12.service;

import java.util.ArrayList;

import com.lec.ch12.dao.MemberRepository;
import com.lec.ch12.dto.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberRepository memberRepository = MemberRepository.getInstace();
		ArrayList<Member> memberList = memberRepository.getMemberList();
		request.setAttribute("memberList", memberList);
	}

}
