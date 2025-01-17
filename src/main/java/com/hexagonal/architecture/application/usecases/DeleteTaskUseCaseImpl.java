package com.hexagonal.architecture.application.usecases;

import com.hexagonal.architecture.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.architecture.domain.ports.out.TaskRepositoryPort;

/**
 * The type Delete task use case.
 */
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

  private final TaskRepositoryPort taskRepositoryPort;

  /**
   * Instantiates a new Delete task use case.
   *
   * @param taskRepositoryPort the task repository port
   */
  public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
    this.taskRepositoryPort = taskRepositoryPort;
  }

  @Override
  public boolean deleteTask(Long id) {
    return taskRepositoryPort.deleteById(id);
  }
}
