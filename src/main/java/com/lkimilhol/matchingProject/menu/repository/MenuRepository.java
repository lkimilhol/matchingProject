package com.lkimilhol.matchingProject.menu.repository;

import java.util.List;

import com.lkimilhol.matchingProject.menu.domain.Menu;

public interface MenuRepository {
	Long save(Menu menu);
	Menu findById(Long id);
	List<Menu> findAll(Long shopId);
}
