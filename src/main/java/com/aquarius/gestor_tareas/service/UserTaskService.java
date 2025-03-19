package com.aquarius.gestor_tareas.service;

import com.aquarius.gestor_tareas.model.UserTask;

import java.util.Optional;

public interface UserTaskService {

    UserTask findUserTask(String email);
}
