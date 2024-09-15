package com.hexagonal.architecture.domain.ports.in;

import com.hexagonal.architecture.domain.models.Tasks;
import java.util.Optional;

/**
 * The interface Update task use case.
 */
public interface UpdateTaskUseCase {
  /**
   * Update task optional.
   *
   * @param id the id
   * @param updateTask the update task
   * @return the optional
   */
  Optional<Tasks> updateTask(Long id, Tasks updateTask);
}
