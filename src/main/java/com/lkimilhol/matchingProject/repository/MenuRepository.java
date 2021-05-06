package com.lkimilhol.matchingProject.repository;

import java.util.List;

import com.lkimilhol.matchingProject.domain.Menu;

public interface MenuRepository {
	Long save(Menu menu);
	Menu findById(Long id);
	List<Menu> findAll(Long shopId);
}
