package com.practiceTodo.todolist.service.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.practiceTodo.todolist.domain.todo.Todo;
import com.practiceTodo.todolist.domain.todo.TodoRepository;
import com.practiceTodo.todolist.web.dto.todo.CreateReqDto;
import com.practiceTodo.todolist.web.dto.todo.TodolistRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

	private final TodoRepository todoRepository;
	
	//생성
	@Override
	public boolean createTodo(CreateReqDto createReqDto) throws Exception {
		Todo todoEntity = createReqDto.todoEntity();
		
//		String content = todoEntity.getTodo_content();
//		for(int i = 0; i < 200; i++) {
//			todoEntity.setTodo_content(content + "_" + (i + 1));
//			if(i % 2 == 0) {
//				todoEntity.setImportance_flag(1);
//			}else {
//				todoEntity.setImportance_flag(0);
//			}
//				todoRepository.save(todoEntity);
//		}
//		return true;
		
		return todoRepository.save(todoEntity) > 0;
	}
	
	//조회
	@Override
	public List<TodolistRespDto> getTodo(String type, int page, int contentCount) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("index", (page -1 ) * contentCount);
		map.put("count", contentCount);
		
		
		List<Todo> todoList = todoRepository.getTodolist(map);
		List<TodolistRespDto> todoListRespDtos = new ArrayList<TodolistRespDto>();
		todoList.forEach(todo -> {
			todoListRespDtos.add(todo.toListDto());
		});
		
		return todoListRespDtos;
	}
	
}
