package com.kajishima.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Field implements Serializable {

	private Integer id;
	private String fieldName;

}
