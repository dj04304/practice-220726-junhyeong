package com.practiceTodo.todolist.web.contoller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practiceTodo.todolist.service.todo.TodoService;
import com.practiceTodo.todolist.web.dto.CMRespDto;
import com.practiceTodo.todolist.web.dto.todo.CreateTodoReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService todoService;

	@PostMapping("/content")
	public ResponseEntity<?> addTodo(@RequestBody CreateTodoReqDto createTodoReqDto) {
		
		try {
			todoService.createTodo(createTodoReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "error to create todolist", createTodoReqDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success to create todolist", createTodoReqDto));
	}
}
