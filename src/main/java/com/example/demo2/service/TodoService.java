package com.example.demo2.service;

import com.example.demo2.entity.Todo;
import com.example.demo2.model.TodoRequest;
import com.example.demo2.model.TodoUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Optional<List<Todo>> findTodoByUserId(String userId);

    List<Todo> list();

    Optional<Todo> findTodoById(long id);

    Todo create(TodoRequest todo);

    Todo update(long id, TodoUpdateRequest todo);

    String delete(long id);
}
