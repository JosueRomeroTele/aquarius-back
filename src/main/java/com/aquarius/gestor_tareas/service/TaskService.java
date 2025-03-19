package com.aquarius.gestor_tareas.service;

import com.aquarius.gestor_tareas.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> listAll();

    Task saveTask(Task task);

    boolean deleteTask(Long id);

    List<Task> listByUser(Long idUser);

    Task updateTask(long id,Task task);

    Task getTask(long idTask);

    boolean deleteTask(long idTask);
}
