package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}
