package com.kajishima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kajishima.entity.Field;
import com.kajishima.service.FieldManagerService;

@RestController
public class FieldController {
	@Autowired
	private FieldManagerService fieldManagerService;

	@RequestMapping(value="/fields",method=RequestMethod.GET)
	public List<Field>list() {
		return fieldManagerService.fieldList();
	}

}
