package com.study.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.domain.Board;

/*
 * @Mapper : MyBatis의 mapper interface임을 나타내줌
 			MyBatis의 xml에 있는 sql쿼리와 매핑을 자동으로 해줌 
 */

@Mapper
public interface BoardDao {
	public List<Board> list();
	public int totalRecord();
	public Board detailBoard(String boardno);
	public int insertBoard(Board b);
	public int deleteBoard(String boardno);
}
