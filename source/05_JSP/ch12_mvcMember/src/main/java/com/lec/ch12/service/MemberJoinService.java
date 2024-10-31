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
		String memberJoinResult = "";
		int joinResult = 0;
		Date birth = null;
		if(!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		MemberRepository memberRepository = MemberRepository.getInstace();
		if(memberRepository.getCountMember(id) == MemberRepository.MEMBER_NONEXISTENT) {
			joinResult = memberRepository.insertMember(new Member(id, pw, name, birth, null));
			if(joinResult == MemberRepository.SUCCESS) {
				memberJoinResult = "회원가입 성공했습니다";				
			}else {
				memberJoinResult = "회원가입 실패했습니다";							
			}
		}else if (memberRepository.getCountMember(id) == MemberRepository.MEMBER_EXISTENT){
			memberJoinResult = "중복된 ID는 사용할 수 없습니다";
		}
		request.setAttribute("joinResult", joinResult);
		request.setAttribute("memberJoinResult", memberJoinResult);			
	}

}
