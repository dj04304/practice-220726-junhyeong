package com.practiceTodo.todolist.web.contoller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practiceTodo.todolist.service.todo.TodoService;
import com.practiceTodo.todolist.web.dto.CMRespDto;
import com.practiceTodo.todolist.web.dto.todo.CreateReqDto;
import com.practiceTodo.todolist.web.dto.todo.TodolistRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService todoService;

	// todolist 생성
	@PostMapping("/content")
	public ResponseEntity<?> addTodo(@RequestBody CreateReqDto createReqDto) {
		
		try {
			if(!todoService.createTodo(createReqDto)) {
				throw new RuntimeException("DataBase Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "add failed", createReqDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "add success", createReqDto));
	}
	
	//todolist 조회 
	@GetMapping("/{type}")
	public ResponseEntity<?> getTodo(@PathVariable String type, @RequestParam int page, @RequestParam int contentCount) {
		List<TodolistRespDto> list = null;
		
		try {
			list = todoService.getTodo(type, page, contentCount);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, page +"failed get list", page));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, page + "success get list", list));
	}
	
}
