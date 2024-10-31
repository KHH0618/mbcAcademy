package com.lec.service;

import java.util.ArrayList;

import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonList implements Service {

	@Override
	public void extend(HttpServletRequest request, HttpServletResponse response) {
		PersonRepository repository = PersonRepository.getInstance();
		request.setAttribute("personList", repository.getPersonList());
	}

}
