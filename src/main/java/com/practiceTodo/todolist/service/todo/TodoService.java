package com.practiceTodo.todolist.service.todo;

import org.springframework.stereotype.Service;

import com.practiceTodo.todolist.web.dto.todo.CreateTodoReqDto;


public interface TodoService {
	//생성
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception;
	//조회
	//수정
	//삭제
}
