package com.raveri.javadockermvn.controller;

import com.raveri.javadockermvn.model.Todo;
import com.raveri.javadockermvn.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/todo")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(todoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<Object> create(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/todo")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(!todo.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        todoRepository.delete(todo.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
