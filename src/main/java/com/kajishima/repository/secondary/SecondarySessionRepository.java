package com.kajishima.repository.secondary;

import java.util.List;

import com.kajishima.entity.secondary.Session;

public interface SecondarySessionRepository {

	public List<Session> selectAll();

}
