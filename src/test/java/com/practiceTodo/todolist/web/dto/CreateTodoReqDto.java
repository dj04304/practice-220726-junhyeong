package com.practiceTodo.todolist.web.dto;

import lombok.Data;

@Data
public class CreateTodoReqDto {
	private boolean importance;
	private String todo;
}
