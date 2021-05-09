package com.lkimilhol.matchingProject.repository.JPA;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.lkimilhol.matchingProject.domain.Menu;
import com.lkimilhol.matchingProject.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MenuRepositoryJpa implements MenuRepository {
	private final EntityManager em;

	@Override
	public Long save(Menu menu) {
		em.persist(menu);
		return menu.getId();
	}

	@Override
	public Menu findById(Long id) {
		return em.find(Menu.class, id);
	}

	@Override
	public List<Menu> findAll(Long shopId) {
		return null;
	}
}
