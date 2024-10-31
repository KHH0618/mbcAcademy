package com.lec.service;

import java.sql.Date;

import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertPerson implements Service {

	@Override
	public void extend(HttpServletRequest request, HttpServletResponse response) {
		PersonRepository repository = PersonRepository.getInstance();
		int result = PersonRepository.FAIL;
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		String memo = request.getParameter("memo");
		Date birth = null;
		System.out.println(birthStr);
		if(!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		Person person = new Person(name, tel, address, birth, memo);
		result = repository.insertPerson(person);
		request.setAttribute("insertResult", result);
	}

}
