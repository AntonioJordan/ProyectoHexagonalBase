package com.hexagonal.architecture.domain.ports.in;


import com.hexagonal.architecture.domain.models.Tasks;
import java.util.List;
import java.util.Optional;

/**
 * The interface Retrieve task use case.
 */
public interface RetrieveTaskUseCase {
  /**
   * Gets task.
   *
   * @param id the id
   * @return the task
   */
  Optional<Tasks> getTask(Long id);

  /**
   * Gets all tasks.
   *
   * @return the all tasks
   */
  List<Tasks> getAllTasks();
}
