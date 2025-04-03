package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Menu;
import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

	List<Menu> findByType(Type type);

	List<Menu> findByTypeAndTaste(Type type, Taste taste);

}
