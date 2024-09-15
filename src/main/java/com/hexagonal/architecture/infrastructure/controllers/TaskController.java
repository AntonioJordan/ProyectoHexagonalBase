package com.hexagonal.architecture.infrastructure.controllers;

import com.hexagonal.architecture.application.services.TaskService;
import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.domain.models.Tasks;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Task controller.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  private final TaskService taskService;

  /**
   * Instantiates a new Task controller.
   *
   * @param taskService the task service
   */
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  /**
   * Create task response entity.
   *
   * @param task the task
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Tasks> createTask(@RequestBody Tasks task) {
    final Tasks createdTask = taskService.createTask(task);
    return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
  }

  /**
   * Gets task by id.
   *
   * @param taskId the task id
   * @return the task by id
   */
  @GetMapping("/{taskId}")
  public ResponseEntity<Tasks> getTaskById(@PathVariable Long taskId) {
    return taskService.getTask(taskId)
        .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  /**
   * Get all tasks response entity.
   *
   * @return the response entity
   */
  @GetMapping
  public ResponseEntity<List<Tasks>> getAllTasks() {
    List<Tasks> tasks = taskService.getAllTasks();
    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }

  /**
   * Update task response entity.
   *
   * @param taskId the task id
   * @param updateTask the update task
   * @return the response entity
   */
  @PutMapping("{taskId}")
  public ResponseEntity<Tasks> updateTask(@PathVariable Long taskId, @RequestBody Tasks updateTask) {
    return taskService.updateTask(taskId, updateTask)
        .map(tasks -> new ResponseEntity<>(tasks, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  /**
   * Delete task by id response entity.
   *
   * @param taskId the task id
   * @return the response entity
   */
  @DeleteMapping("/{taskId}")
  public ResponseEntity<Void> deleteTaskById(@PathVariable Long taskId) {
    if (taskService.deleteTask(taskId)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Get additional task inf response entity.
   *
   * @param taskId the task id
   * @return the response entity
   */
  @GetMapping("/{taskId}/aditionalInfo")
  public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInf(@PathVariable Long taskId) {
    AdditionalTaskInfo additionalTaskInfo = taskService.getAdditionalTaskInfo(taskId);
    return new ResponseEntity<>(additionalTaskInfo, HttpStatus.OK);
  }
}
