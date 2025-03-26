package com.study.springboot.domain;

import lombok.Data;

@Data
public class Board {
	private int boardno;
	private String title;
	private String writer;
	private String content;
	
	
}
