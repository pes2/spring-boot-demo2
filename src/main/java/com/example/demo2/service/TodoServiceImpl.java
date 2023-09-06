package com.example.demo2.service;

import com.example.demo2.dao.TodoRepository;
import com.example.demo2.entity.Todo;
import com.example.demo2.exception.TodoNotFoundException;
import com.example.demo2.model.TodoRequest;
import com.example.demo2.model.TodoUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoServiceImpl implements TodoService  {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Optional<List<Todo>> findTodoByUserId(String userId) {
        if(userId != null && !userId.isEmpty()) {
            return todoRepository.findTodoByUserId(userId);
        }

        return Optional.empty();
    }

    @Override
    public List<Todo> list() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findTodoById(long id) {
        if(!todoRepository.existsById(id)) {
            log.info("findTodoById() not found -> throw TodoNotFoundException()");
            throw new TodoNotFoundException("Find Failed - Todo with id " + id + " does not exist");
        }
        return todoRepository.findTodoById(id);
    }

    @Override
    public Todo create(TodoRequest todo) {
        if(todo != null) {
            Todo newTodo = new Todo();
            newTodo.setUserId(todo.getUserId());
            newTodo.setTitle(todo.getTitle());
            newTodo.setCompleted(todo.getCompleted());
            return todoRepository.save(newTodo);
        }
        return null;
    }

    @Override
    public Todo update(long id, TodoUpdateRequest todo) {
        if(!todoRepository.existsById(id)) {
            throw new TodoNotFoundException("Update Failed - Todo with id " + id + " does not exist");
        }

        Todo todoToBeUpdated = todoRepository.getById(id);
        todoToBeUpdated.copy(todo);

        return todoRepository.save(todoToBeUpdated);
    }

    @Override
    public String delete(long id) {
        if(!todoRepository.existsById(id)) {
            throw new TodoNotFoundException("Delete Failed - Todo with id " + id + " does not exist");
        }
        todoRepository.deleteById(id);
        return "deleted";
    }





}
