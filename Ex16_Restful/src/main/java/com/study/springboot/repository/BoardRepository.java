package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

}
