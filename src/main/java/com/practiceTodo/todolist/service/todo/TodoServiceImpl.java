package com.practiceTodo.todolist.service.todo;

import org.springframework.stereotype.Service;

import com.practiceTodo.todolist.domain.todo.Todo;
import com.practiceTodo.todolist.domain.todo.TodoRepository;
import com.practiceTodo.todolist.web.dto.todo.CreateTodoReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
	
	private final TodoRepository todoRepository;

	@Override
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception {
		Todo todoEntity = createTodoReqDto.todoEntity();
			
		return todoRepository.save(todoEntity) > 0;
	}

}
