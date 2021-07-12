package com.lkimilhol.matchingproject.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMenu {
	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	private Long shopId;

	@NotNull
	@Min(0)
	private int amount;
}
