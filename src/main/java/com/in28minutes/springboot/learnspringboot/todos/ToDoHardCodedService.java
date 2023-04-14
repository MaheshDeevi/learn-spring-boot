package com.in28minutes.springboot.learnspringboot.todos;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoHardCodedService {

    private static List<ToDo> todos = new ArrayList<>();
    private static long idCounter=0;

    static {
        todos.add(new ToDo(++idCounter,"admin","Learn Java",new Date(),false));
        todos.add(new ToDo(++idCounter,"admin","Learn Spring",new Date(),false));
        todos.add(new ToDo(++idCounter,"admin","Learn DevOps",new Date(),false));
    }

    public List<ToDo> getAll(){
        return todos;
    }

    public ToDo findById(long id){
        for(ToDo todo:todos){
            if(todo.getId()==id){
                return todo;
            }
        }
        return null;
    }

    public boolean deleteById(long id){
        ToDo toDo = findById(id);

        if(todos.remove(toDo)){
            return true;
        }
        return false;
    }

    public ToDo save(ToDo todo){
        if(todo.getId()==-1 || todo.getId()==0 ){
           todo.setId(++idCounter);
           todos.add(todo);
        }
        else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}
