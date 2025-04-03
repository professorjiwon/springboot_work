package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Menu;
import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;
import com.study.springboot.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuRestController {
	
	@Autowired
	MenuService menuService;
	
	@GetMapping
	public List<Menu> menuAllList() {
		return menuService.menuAllList();
	}
	
	//  /menu/type/${e.target.value}
	//  /menu/type/KR, /menu/type/CH, /menu/type/JP
	// {변수명} : URL의 변수로서 클라이언트가 요청할 때 경로에 포함된 값을 파라미터로 전달
	@GetMapping("/type/{type}")
	public List<Menu> findByType(@PathVariable(name="type") Type type) {
		return menuService.findByType(type);
	}
	
	// /menu/type/${type}/taste/${taste}
	@GetMapping("/type/{type}/taste/{taste}")
	public List<Menu> findByTypeAndTaste(@PathVariable(name="type") Type type ,
										 @PathVariable(name="taste") Taste taste)
	{	
		return menuService.findByTypeAndTaste(type, taste); 
	}
	
	@GetMapping("/{id}")
	public Menu findById(@PathVariable(name="id") Long id) {
		return menuService.findById(id).get();
	}
}










