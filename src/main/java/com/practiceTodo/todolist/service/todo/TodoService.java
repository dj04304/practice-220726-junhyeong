package com.practiceTodo.todolist.service.todo;

import java.util.List;

import com.practiceTodo.todolist.web.dto.todo.CreateReqDto;
import com.practiceTodo.todolist.web.dto.todo.TodolistRespDto;

public interface TodoService {

	//생성
	public boolean createTodo(CreateReqDto createReqDto) throws Exception; 
	
	//조회
	public List<TodolistRespDto> getTodo(String type, int page, int contentCount) throws Exception;
}
