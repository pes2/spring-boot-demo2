package com.example.demo2.controller;

import com.example.demo2.entity.Todo;
import com.example.demo2.model.TodoRequest;
import com.example.demo2.model.TodoUpdateRequest;
import com.example.demo2.service.TodoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping( value = "/api/v1/todos", produces = "application/json")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoService;

    @GetMapping("")
    public List<Todo> getTodos() {
        return todoService.list();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable long id) {
        return todoService.findTodoById(id).orElse(null);
    }

    @GetMapping("/{id}/userId")
    public Todo getTodo2(@PathVariable long id, @RequestParam String userId) {
        //log.info("Special key: " + userId);
        return todoService.findTodoById(id).orElse(null);
    }

    @PostMapping("")
    public Todo createTodo(@Valid @RequestBody TodoRequest todo) {
        return todoService.create(todo);
    }

    @PostMapping("/{id}")
    public Todo updateTodo(@PathVariable long id, @Valid @RequestBody TodoUpdateRequest todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable long id) {
        return todoService.delete(id);
    }
}
