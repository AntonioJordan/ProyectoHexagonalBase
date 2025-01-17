package com.hexagonal.architecture.domain.ports.in;

import com.hexagonal.architecture.domain.models.Tasks;

/**
 * The interface Create task use case.
 */
public interface CreateTaskUseCase {
  /**
   * Create task tasks.
   *
   * @param task the task
   * @return the tasks
   */
  Tasks createTask(Tasks task);
}
