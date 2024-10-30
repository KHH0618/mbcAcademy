package com.lec.ch12.dao;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.lec.ch12.dto.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberRepositoryTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberRepository memberRepository = MemberRepository.getInstace();
		ArrayList<Member> members = memberRepository.getMemberList();
		for(Member member : members) {
			System.out.println(member);
		}
		Member newMember = new Member("ddd","abc","김길순", new Date(100,00,01), null);
		
		System.out.println(newMember);
		int chkId = memberRepository.getCountMember(newMember.getId());
		if(chkId == MemberRepository.MEMBER_NONEXISTENT) {
			int result = memberRepository.insertMember(newMember);
			System.out.println(result == MemberRepository.SUCCESS? "가입성공":"가입 실패");
		}else {
			System.out.println("이써");
		}
	}

}
