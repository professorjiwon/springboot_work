package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Menu;
import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;
import com.study.springboot.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;

	public List<Menu> menuAllList() {
		return menuRepository.findAll();
	}

	public List<Menu> findByType(Type type) {
		return menuRepository.findByType(type);
	}

	public List<Menu> findByTypeAndTaste(Type type, Taste taste) {
		return menuRepository.findByTypeAndTaste(type, taste);
	}

	public Optional<Menu> findById(Long id) {
		return menuRepository.findById(id);
	}

	public Menu insertMenu(Menu menu) {
		return menuRepository.save(menu);
	}

	public Menu updateMenu(Menu menu) {
		return menuRepository.save(menu);
	}

}
