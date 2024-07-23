package com.kocak.task_management;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepo taskRepo;

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        }
        log.info("Task with id: {} doesn't exist", id);
        return null;
    }

    public void saveTask(Task task) {
        task.setCreated(Instant.now());
        if (this.getTaskById(task.getId()) != null) {
            throw new RuntimeException("task with id ${task.getId()} already exists");
        }
        taskRepo.save(task);

        log.info("Task with with id: {} saved successfully", task.getId());
    }

    public void updateTask(Task task) {
        Optional<Task> existingTask = taskRepo.findById(task.getId());
        existingTask.ifPresent(value -> task.setCreated(value.getCreated()));

        taskRepo.save(task);

        log.info("Task with with id: {} updated successfully", task.getId());
    }

    public void deleteTask(Long id) {
        if(getTaskById(id) != null){
        taskRepo.deleteById(id);
        } else {
            throw new RuntimeException("task with id ${task.getId()} does not exists");
        }
        log.info("Task with with id: {} deleted successfully", id);
    }


}
