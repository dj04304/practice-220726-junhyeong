package com.practiceTodo.todolist.domain.todo;

import java.time.LocalDateTime;

import com.practiceTodo.todolist.web.dto.todo.TodolistRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
	private int todo_code;
	private String todo_content;
	private int todo_complete;
	private int importance_flag;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	public TodolistRespDto toListDto() {
		return TodolistRespDto.builder()
				.todoCode(todo_code)
				.todo(todo_content)
				.complete(todo_complete == 1)
				.importance(importance_flag == 1)
				.createDate(create_date)
				.updatDate(update_date)
				.build();
	}
}
