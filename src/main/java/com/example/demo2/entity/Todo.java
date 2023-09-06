package com.example.demo2.entity;

import com.example.demo2.model.TodoUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // user can have many todos, but _todo can only hava one user
    private Long userId;

    private String title;

    private Boolean completed;

    // For copy/update purposes
    public Todo(Long userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    // copy only fields that have 'new' value

    public void copy(final TodoUpdateRequest todo) {
        if(todo.getUserId() != null) {
            this.setUserId(todo.getUserId());
        }

        if(todo.getTitle() != null) {
            this.setTitle(todo.getTitle());
        }

        if(todo.getCompleted() != null) {
            this.setCompleted(todo.getCompleted());
        }
    }




}
