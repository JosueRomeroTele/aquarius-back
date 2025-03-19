package com.aquarius.gestor_tareas.service.Impl;

import com.aquarius.gestor_tareas.model.UserTask;
import com.aquarius.gestor_tareas.repository.UserTaskRepository;
import com.aquarius.gestor_tareas.service.UserTaskService;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserTaskServiceImpl  implements UserTaskService {

    private final UserTaskRepository repository;
    @Override
    public UserTask findUserTask(String email) {
        return repository.findByEmail(email).orElseThrow(()-> new RuntimeException("Usuario No encontrado"));
    }
}
