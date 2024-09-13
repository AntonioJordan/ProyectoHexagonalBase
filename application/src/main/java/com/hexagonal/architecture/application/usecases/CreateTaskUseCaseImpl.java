package com.hexagonal.architecture.application.usecases;

import com.hexagonal.architecture.domain.models.Tasks;
import com.hexagonal.architecture.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.architecture.domain.ports.out.TaskRepositoryPort;

/**
 * The type Create task use case.
 */
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

  private final TaskRepositoryPort taskRepositoryPort;

  /**
   * Instantiates a new Create task use case.
   *
   * @param taskRepositoryPort the task repository port
   */
  public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
    this.taskRepositoryPort = taskRepositoryPort;
  }

  @Override
  public Tasks createTask(Tasks task) {
    return taskRepositoryPort.save(task);
  }
}
