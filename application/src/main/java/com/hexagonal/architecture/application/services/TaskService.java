package com.hexagonal.architecture.application.services;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.domain.models.Tasks;
import com.hexagonal.architecture.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.architecture.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.architecture.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.architecture.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.architecture.domain.ports.in.UpdateTaskUseCase;
import java.util.List;
import java.util.Optional;

/**
 * The type Task service.
 */
public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase,
    GetAdditionalTaskInfoUseCase {

  private final CreateTaskUseCase createTaskUseCase;
  private final RetrieveTaskUseCase retrieveTaskUseCase;
  private final UpdateTaskUseCase updateTaskUseCase;
  private final DeleteTaskUseCase deleteTaskUseCase;
  private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

  /**
   * Instantiates a new Task service.
   *
   * @param createTaskUseCase the create task use case
   * @param retrieveTaskUseCase the retrieve task use case
   * @param updateTaskUseCase the update task use case
   * @param deleteTaskUseCase the delete task use case
   * @param getAdditionalTaskInfoUseCase the get additional task info use case
   */
  public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase,
                     UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase,
                     GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
    this.createTaskUseCase = createTaskUseCase;
    this.retrieveTaskUseCase = retrieveTaskUseCase;
    this.updateTaskUseCase = updateTaskUseCase;
    this.deleteTaskUseCase = deleteTaskUseCase;
    this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
  }

  @Override
  public Tasks createTask(Tasks task) {
    return createTaskUseCase.createTask(task);
  }

  @Override
  public boolean deleteTask(Long id) {
    return deleteTaskUseCase.deleteTask(id);
  }

  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
    return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
  }

  @Override
  public Optional<Tasks> getTask(Long id) {
    return retrieveTaskUseCase.getTask(id);
  }

  @Override
  public List<Tasks> getAllTasks() {
    return retrieveTaskUseCase.getAllTasks();
  }

  @Override
  public Optional<Tasks> updateTask(Long id, Tasks updateTask) {
    return updateTaskUseCase.updateTask(id, updateTask);
  }
}
