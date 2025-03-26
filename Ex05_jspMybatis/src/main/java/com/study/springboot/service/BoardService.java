package com.study.springboot.service;

import java.util.List;
import com.study.springboot.domain.Board;

public interface BoardService {
	public List<Board> list();
	public int totalRecord();
	public int insertBoard(Board b);
	public int deleteBoard(String boardno);
}
