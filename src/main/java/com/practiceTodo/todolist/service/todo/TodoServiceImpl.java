package com.practiceTodo.todolist.service.todo;

import org.springframework.stereotype.Service;

import com.practiceTodo.todolist.web.dto.todo.CreateTodoReqDto;

@Service
public class TodoServiceImpl implements TodoService{

	@Override
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception {
		System.out.println(createTodoReqDto);
		
		if(1 == 1) {
			throw new RuntimeException();
		}
		
		return false;
	}

}
