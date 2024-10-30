package com.lec.ch12.service;

import java.sql.Date;

import com.lec.ch12.dao.MemberRepository;
import com.lec.ch12.dto.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthStr = request.getParameter("birth");
		int joinResult = 0;
		Date birth = null;
		if(!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);			
		}
		MemberRepository memberRepository = MemberRepository.getInstace();
		if(memberRepository.getCountMember(id) == MemberRepository.MEMBER_NONEXISTENT) {
			joinResult = memberRepository.insertMember(new Member(id, pw, name, birth, null));
			request.setAttribute("joinResult", joinResult);
		}else {
			
		}
	}

}
