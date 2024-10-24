package com.todo.todo_app.Service.Impl;

import com.todo.todo_app.Model.To_do;
import com.todo.todo_app.Repository.TodoRepo;
import com.todo.todo_app.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class TodoServiceImpl implements Service {
    @Autowired
    private TodoRepo todoRepo;
    @Override
    public To_do saveTodo(To_do todo) {
        return todoRepo.save(todo);
    }

    @Override
    public List<To_do> getAlltodo() {
        return todoRepo.findAll();
    }

    @Override
    public To_do getTodoById(Long id) {
        return todoRepo.findById(id).orElseThrow(()->
        new RuntimeException("Todo not found!!"));
    }

    @Override
    public To_do updateTodo(To_do todo, Long id) {
        To_do existingTodo=  todoRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Todo not found!!"));
        existingTodo.setId(todo.getId());
        existingTodo.setDone(todo.isDone());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setTitle(todo.getTitle());
        return todoRepo.save(existingTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepo.findById(id).orElseThrow(()->
                new RuntimeException("Todo not found!!"));
        todoRepo.deleteById(id);
    }
}
