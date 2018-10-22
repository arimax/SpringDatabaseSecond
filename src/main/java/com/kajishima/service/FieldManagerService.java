package com.kajishima.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajishima.entity.Field;
import com.kajishima.repository.primary.FieldRepository;

@Service
//@Transactional(transactionManager = "primaryManager")
public class FieldManagerService {

	@Autowired
	private FieldRepository fieldRepository;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public List<Field> fieldList() {

		SqlSession session = sqlSessionFactory.openSession();
		FieldRepository mapper = session.getMapper(FieldRepository.class);

		List<Field> list = mapper.selectAll();
        session.close();

		return fieldRepository.selectAll();
	}

}
