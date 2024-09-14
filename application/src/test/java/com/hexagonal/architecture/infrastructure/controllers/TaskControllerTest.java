package com.hexagonal.architecture.infrastructure.controllers;

import com.hexagonal.architecture.application.services.TaskService;
import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.domain.models.Tasks;
import java.util.List;
import java.util.Optional;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The type Task controller test.
 */
@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

  @Mock
  private TaskService taskService;

  @InjectMocks
  private TaskController taskController;

  private EasyRandom easyRandom;

  /**
   * Sets up.
   */
  @BeforeEach
  void setUp() {
    easyRandom = new EasyRandom();
  }

  /**
   * Test create task.
   */
  @Test
  void testCreateTask() {
    //given
    Tasks task = easyRandom.nextObject(Tasks.class);
    Mockito.when(taskService.createTask(Mockito.any(Tasks.class))).thenReturn(task);

    //when
    ResponseEntity<Tasks> response = taskController.createTask(task);

    //then
    Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    Assertions.assertEquals(task, response.getBody());
    Mockito.verify(taskService, Mockito.times(1)).createTask(task);
  }

  /**
   * Test get task by id task found.
   */
  @Test
  void testGetTaskById_TaskFound() {
    //given
    Tasks task = easyRandom.nextObject(Tasks.class);
    Mockito.when(taskService.getTask(Mockito.anyLong())).thenReturn(Optional.of(task));

    //when
    ResponseEntity<Tasks> response = taskController.getTaskById(1L);

    //then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(task, response.getBody());
    Mockito.verify(taskService, Mockito.times(1)).getTask(1L);
  }

  /**
   * Test get task by id task not found.
   */
  @Test
  void testGetTaskById_TaskNotFound() {
    //given
    Mockito.when(taskService.getTask(Mockito.anyLong())).thenReturn(Optional.empty());

    //when
    ResponseEntity<Tasks> response = taskController.getTaskById(1L);

    //then
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    Mockito.verify(taskService, Mockito.times(1)).getTask(1L);
  }

  /**
   * Test get all tasks.
   */
  @Test
  void testGetAllTasks() {
    //given
    List<Tasks> taskList = easyRandom.objects(Tasks.class, 5).toList();
    Mockito.when(taskService.getAllTasks()).thenReturn(taskList);

    //when
    ResponseEntity<List<Tasks>> response = taskController.getAllTasks();

    //then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(taskList, response.getBody());
    Mockito.verify(taskService, Mockito.times(1)).getAllTasks();
  }

  /**
   * Test update task task found.
   */
  @Test
  void testUpdateTask_TaskFound() {
    //given
    Tasks updatedTask = easyRandom.nextObject(Tasks.class);
    Mockito.when(taskService.updateTask(Mockito.anyLong(), Mockito.any(Tasks.class))).thenReturn(Optional.of(updatedTask));

    //when
    ResponseEntity<Tasks> response = taskController.updateTask(1L, updatedTask);

    //then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(updatedTask, response.getBody());
    Mockito.verify(taskService, Mockito.times(1)).updateTask(1L, updatedTask);
  }

  /**
   * Test update task task not found.
   */
  @Test
  void testUpdateTask_TaskNotFound() {
    //given
    Tasks updatedTask = easyRandom.nextObject(Tasks.class);
    Mockito.when(taskService.updateTask(Mockito.anyLong(), Mockito.any(Tasks.class))).thenReturn(Optional.empty());

    //when
    ResponseEntity<Tasks> response = taskController.updateTask(1L, updatedTask);

    //then
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    Mockito.verify(taskService, Mockito.times(1)).updateTask(1L, updatedTask);
  }

  /**
   * Test delete task by id task deleted.
   */
  @Test
  void testDeleteTaskById_TaskDeleted() {
    //given
    Mockito.when(taskService.deleteTask(Mockito.anyLong())).thenReturn(true);

    //when
    ResponseEntity<Void> response = taskController.deleteTaskById(1L);

    //then
    Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    Mockito.verify(taskService, Mockito.times(1)).deleteTask(1L);
  }

  /**
   * Test delete task by id task not found.
   */
  @Test
  void testDeleteTaskById_TaskNotFound() {
    //given
    Mockito.when(taskService.deleteTask(Mockito.anyLong())).thenReturn(false);

    //when
    ResponseEntity<Void> response = taskController.deleteTaskById(1L);

    //then
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    Mockito.verify(taskService, Mockito.times(1)).deleteTask(1L);
  }

  /**
   * Test get additional task inf.
   */
  @Test
  void testGetAdditionalTaskInf() {
    //given
    AdditionalTaskInfo additionalTaskInfo = easyRandom.nextObject(AdditionalTaskInfo.class);
    Mockito.when(taskService.getAdditionalTaskInfo(Mockito.anyLong())).thenReturn(additionalTaskInfo);

    //when
    ResponseEntity<AdditionalTaskInfo> response = taskController.getAdditionalTaskInf(1L);

    //then
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    Assertions.assertEquals(additionalTaskInfo, response.getBody());
    Mockito.verify(taskService, Mockito.times(1)).getAdditionalTaskInfo(1L);
  }
}