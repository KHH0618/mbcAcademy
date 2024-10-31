package com.lec.service;

import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonInfo implements Service {

	@Override
	public void extend(HttpServletRequest request, HttpServletResponse response) {
		PersonRepository repository = PersonRepository.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("person", repository.getPerson(id));
	}

}
