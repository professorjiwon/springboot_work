package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

	List<Reply> findByRefBnoOrderByRnoDesc(Long bno);

}
