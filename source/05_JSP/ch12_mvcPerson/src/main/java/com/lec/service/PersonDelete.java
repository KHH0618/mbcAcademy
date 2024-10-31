package com.lec.service;

import com.lec.dao.PersonRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonDelete implements Service {

	@Override
	public void extend(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		PersonRepository personRepository = PersonRepository.getInstance();
		request.setAttribute("deleteResult", personRepository.deletePerson(id));
	}

}
