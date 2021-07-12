package com.lkimilhol.matchingProject.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingProject.menu.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
