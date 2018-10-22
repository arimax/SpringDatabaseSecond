package com.kajishima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kajishima.entity.secondary.Session;
import com.kajishima.repository.secondary.SecondarySessionRepository;

@RestController
public class SecondarySessionController {

	@Autowired
	private SecondarySessionRepository sessionRepository;

	@RequestMapping(value="/secondary/session",method=RequestMethod.GET)
	public List<Session> list() {

		return sessionRepository.selectAll();
	}

}
