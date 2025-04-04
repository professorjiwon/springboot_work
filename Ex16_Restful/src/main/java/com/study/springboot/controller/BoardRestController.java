package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@RestController
@RequestMapping("/rest")
public class BoardRestController {
	@Autowired
	BoardRepository bRepository;
	
	// http://localhost:8080/rest/board	
	// http://localhost:8080/rest/board?title=제목&content=내용2
	@GetMapping("/boards")
	List<Board> all(@RequestParam(value="title", required=false) String title,
				    @RequestParam(value="content", required=false) String content) {
		if(title == null && content == null) {
			return bRepository.findAll();
		} else {
			return bRepository.findByTitleOrContent(title, content);
		} 
	}
	
	// http://localhost:8080/rest/boardone/1
	@GetMapping("/boards/{bno}")
	Board getOne(@PathVariable(name="bno") Long bno) {
		return bRepository.findById(bno).get();
	}
	
	
	// http://localhost:8080/rest/board-del/1
	@DeleteMapping("/board-del/{bno}")
	void deleteBoard(@PathVariable(name="bno") Long bno) {
		bRepository.deleteById(bno);
	}
	
}
