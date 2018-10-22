package com.kajishima.repository.secondary;

import java.util.List;

import com.kajishima.entity.secondary.User;

public interface UserRepository {

	public List<User> selectAll();

}
