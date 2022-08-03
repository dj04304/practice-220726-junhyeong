package com.practiceTodo.todolist.web.dto.todo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodolistRespDto {
	private int todoCode;
	private String todo;
	private boolean complete;
	private boolean importance;
	private LocalDateTime createDate;
	private LocalDateTime updatDate;
	
}
