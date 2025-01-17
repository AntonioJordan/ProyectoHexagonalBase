package com.hexagonal.architecture.domain.ports.in;

/**
 * The interface Delete task use case.
 */
public interface DeleteTaskUseCase {
  /**
   * Delete task boolean.
   *
   * @param id the id
   * @return the boolean
   */
  boolean deleteTask(Long id);
}
