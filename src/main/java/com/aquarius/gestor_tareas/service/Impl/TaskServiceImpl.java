package com.aquarius.gestor_tareas.service.Impl;

import com.aquarius.gestor_tareas.model.Task;
import com.aquarius.gestor_tareas.model.UserTask;
import com.aquarius.gestor_tareas.repository.TaskRepository;
import com.aquarius.gestor_tareas.repository.UserTaskRepository;
import com.aquarius.gestor_tareas.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserTaskRepository userTaskRepository;
    @Override
    public List<Task> listAll() {
        return taskRepository.findAll();
    }


    @Override
    public Task saveTask(Task task) {

        return taskRepository.save(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return false;
    }

    @Override
    public List<Task> listByUser(Long idUser) {
        UserTask userTask = userTaskRepository.findById(idUser).orElseThrow(()->new RuntimeException("usuario no existed"));
        if(userTask.getId()!= 0){
            return  taskRepository.findByUserTask(userTask.getId());
        }
        return null;
    }

    @Override
    public Task updateTask(long id, Task taskUpdate) {
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("tarea no encontrada"));
        taskUpdate.setId(task.getId());
        taskUpdate.setUserTask(task.getUserTask());
        taskUpdate.setCreatedAt(task.getCreatedAt());
        return taskRepository.save(taskUpdate);
    }

    @Override
    public Task getTask(long idTask) {
        return taskRepository.findById(idTask).orElseThrow(()->new RuntimeException("Tarea no encontrada"));
    }

    @Override
    public boolean deleteTask(long idTask) {
        taskRepository.deleteById(idTask);
        return true;
    }
}
