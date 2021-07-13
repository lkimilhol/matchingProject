package com.lkimilhol.matchingproject.menu.ui;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.menu.dto.MenuDto;
import com.lkimilhol.matchingproject.request.CreateMenu;
import com.lkimilhol.matchingproject.response.ResultBody;
import com.lkimilhol.matchingproject.menu.application.MenuService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MenuController {

	private final MenuService menuService;

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/menus")
	@ResponseBody
	public ResponseEntity<ResultBody> addMenu(
		@Valid CreateMenu createMenu
	) {
		Menu menu = menuService.createMenu(createMenu);
		return ResponseEntity.ok(new ResultBody(getMenuDto(menu)));
	}

	private MenuDto getMenuDto(Menu menu) {
		return MenuDto.builder().menu(menu).build();
	}
}
