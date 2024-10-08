package com.hexagonal.architecture.application.usecases;

import com.hexagonal.architecture.domain.models.Tasks;
import com.hexagonal.architecture.domain.ports.in.UpdateTaskUseCase;
import com.hexagonal.architecture.domain.ports.out.TaskRepositoryPort;
import java.util.Optional;

/**
 * The type Update task use case.
 */
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

  private final TaskRepositoryPort port;

  /**
   * Instantiates a new Update task use case.
   *
   * @param port the port
   */
  public UpdateTaskUseCaseImpl(TaskRepositoryPort port) {
    this.port = port;
  }

  @Override
  public Optional<Tasks> updateTask(Long id, Tasks updateTask) {
    return port.update(updateTask);
  }
}
