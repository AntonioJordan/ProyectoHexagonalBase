package com.hexagonal.architecture.application.usecases;

import com.hexagonal.architecture.domain.models.Tasks;
import com.hexagonal.architecture.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.architecture.domain.ports.out.TaskRepositoryPort;
import java.util.List;
import java.util.Optional;

/**
 * The type Retrieve task use case.
 */
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

  private final TaskRepositoryPort port;

  /**
   * Instantiates a new Retrieve task use case.
   *
   * @param port the port
   */
  public RetrieveTaskUseCaseImpl(TaskRepositoryPort port) {
    this.port = port;
  }

  @Override
  public Optional<Tasks> getTask(Long id) {
    return port.findById(id);
  }

  @Override
  public List<Tasks> getAllTasks() {
    return port.findAll();
  }
}
