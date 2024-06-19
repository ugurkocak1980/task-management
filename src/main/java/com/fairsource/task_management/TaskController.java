package com.fairsource.task_management;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/task/v1")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    private final TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PostMapping("/")
    public ResponseEntity<List<Task>> saveTask(@RequestBody Task task) {
        taskService.saveTask(task);
        log.info("task with id saved successfully");
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @PutMapping("/")
    public ResponseEntity<List<Task>> updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
        log.info("task with id {} updated successfully", task.getId());
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Task>> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTask(id);
        log.info("task with id {} deleted successfully", id);
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }


}
