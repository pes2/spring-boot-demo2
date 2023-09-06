package com.example.demo2.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoNotFoundException extends RuntimeException  {
    public TodoNotFoundException(String msg) {
        super(msg);
        log.info("TodoNotFoundException()");
    }
}
