package com.in28minutes.springboot.learnspringboot.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ToDoResource {

    @Autowired
    private ToDoHardCodedService toDoService;

    @GetMapping("/users/{username}/todos")
    public List<ToDo> getAllToDos(@PathVariable String username) {
        return toDoService.getAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ToDo getAllToDos(@PathVariable String username, @PathVariable long id) {

        return toDoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable String username, @PathVariable long id) {
        boolean todo = toDoService.deleteById(id);
        if (todo) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<ToDo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo todo) {
        ToDo updatedTodo = toDoService.save(todo);
        return new ResponseEntity<ToDo>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody ToDo todo) {
        ToDo createdTodo = toDoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
