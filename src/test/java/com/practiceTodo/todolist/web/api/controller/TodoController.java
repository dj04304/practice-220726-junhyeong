package com.practiceTodo.todolist.web.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.practiceTodo.todolist.web.dto.CreateTodoReqDto;
import com.practiceTodo.todolist.web.dto.todo.CMRespDto;

public class TodoController {

	public ResponseEntity<?> addTodo(@RequestBody CreateTodoReqDto createTodoReqDto) {
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "test", "testtodolist"));
	}
}
