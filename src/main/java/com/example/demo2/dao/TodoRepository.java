package com.example.demo2.dao;

import com.example.demo2.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository  extends JpaRepository<Todo, Long> {
    Optional<Todo> findTodoById(long id);

    Optional<List<Todo>> findTodoByUserId(String userId);
}
