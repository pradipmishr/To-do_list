package com.todo.todo_app.Service;


import com.todo.todo_app.Model.To_do;

import java.util.List;
import java.util.Optional;

public interface Service {
     To_do saveTodo(To_do todo);
     List<To_do> getAlltodo();

     To_do getTodoById(Long id);

     To_do updateTodo(To_do todo, Long id);

     void deleteTodo(Long id);


}
