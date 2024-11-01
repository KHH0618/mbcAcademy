package com.lec.service;

import java.sql.Date;

import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonUpdate implements Service {

	@Override
	public void extend(HttpServletRequest request, HttpServletResponse response) {
		PersonRepository repository = PersonRepository.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		String memo = request.getParameter("memo");
		Date birth = null;
		if(!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		 repository.updatePerson(new Person(id, name, tel, address, birth, memo));
	}

}
