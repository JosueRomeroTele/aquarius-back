package com.aquarius.gestor_tareas.controller;

import com.aquarius.gestor_tareas.model.Task;
import com.aquarius.gestor_tareas.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor

public class TaskController {

    private final TaskService taskService;

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Task>> listTask(){
        return ResponseEntity.ok().body(taskService.listAll());
    }

    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        taskService.saveTask(task);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping()
    public ResponseEntity<List<Task>> listByUser(@RequestParam("userid") String id){

        return ResponseEntity.ok().body(taskService.listByUser(Long.parseLong(id)));
    }
    @GetMapping("/id")
    public ResponseEntity<Task> getTask(@RequestParam("idTask") long id){
        return ResponseEntity.ok().body(taskService.getTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id,@RequestBody Task task){
        return ResponseEntity.ok().body(taskService.updateTask(id,task));
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deletTask(@RequestParam("idTask") long id){
        return ResponseEntity.ok().body(taskService.deleteTask(id));
    }
}
