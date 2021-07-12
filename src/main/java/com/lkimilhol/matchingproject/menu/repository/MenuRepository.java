package com.lkimilhol.matchingproject.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingproject.menu.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
