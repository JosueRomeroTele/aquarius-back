package com.aquarius.gestor_tareas.repository;

import com.aquarius.gestor_tareas.model.Task;
import com.aquarius.gestor_tareas.model.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByUserTask(Long idUser);
}
