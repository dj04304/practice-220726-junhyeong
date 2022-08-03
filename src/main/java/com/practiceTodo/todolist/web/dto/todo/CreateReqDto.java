package com.practiceTodo.todolist.web.dto.todo;

import com.practiceTodo.todolist.domain.todo.Todo;

import lombok.Data;

@Data
public class CreateReqDto {
	private boolean importance;
	private String todo;
	
	public Todo todoEntity() {
		return Todo.builder()
				.importance_flag(importance ? 1 : 0)
				.todo_content(todo)
				.build();
	}
}
