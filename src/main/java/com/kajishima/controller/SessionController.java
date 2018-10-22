package com.kajishima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kajishima.entity.Session;
import com.kajishima.repository.primary.SessionRepository;

@RestController
public class SessionController {

	@Autowired
	private SessionRepository sessionRepository;

	@RequestMapping(value="/session",method=RequestMethod.GET)
	public List<Session> list() {
		return sessionRepository.selectAll();
	}

}
