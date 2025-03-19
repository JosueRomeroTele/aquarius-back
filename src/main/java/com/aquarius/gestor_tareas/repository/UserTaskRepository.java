package com.aquarius.gestor_tareas.repository;

import com.aquarius.gestor_tareas.model.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask,Long> {


    Optional<UserTask> findByEmail(String email);
}
