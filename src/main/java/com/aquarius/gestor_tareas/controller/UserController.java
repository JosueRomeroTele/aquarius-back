package com.aquarius.gestor_tareas.controller;

import com.aquarius.gestor_tareas.model.UserTask;
import com.aquarius.gestor_tareas.service.UserTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserTaskService service;

    @GetMapping()
    public ResponseEntity<UserTask> getUser(@RequestParam("email") String email){
        return ResponseEntity.ok().body(service.findUserTask(email));
    }

}
