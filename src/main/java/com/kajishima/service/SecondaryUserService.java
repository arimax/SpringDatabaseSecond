package com.kajishima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kajishima.entity.secondary.User;
import com.kajishima.repository.secondary.UserRepository;

@Service
@Transactional(transactionManager = "secondaryManager")
public class SecondaryUserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> list() {
		return userRepository.selectAll();
	}

}
