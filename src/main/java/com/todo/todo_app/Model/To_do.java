package com.todo.todo_app.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "todo_lists")
public class To_do {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean done;

}
