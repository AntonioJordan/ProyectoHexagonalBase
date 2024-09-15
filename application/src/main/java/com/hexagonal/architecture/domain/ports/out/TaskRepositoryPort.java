package com.hexagonal.architecture.domain.ports.out;


import com.hexagonal.architecture.domain.models.Tasks;
import java.util.List;
import java.util.Optional;

/**
 * The interface Task repository port.
 */
public interface TaskRepositoryPort {
  /**
   * Save tasks.
   *
   * @param task the task
   * @return the tasks
   */
  Tasks save(Tasks task);

  /**
   * Find by id optional.
   *
   * @param id the id
   * @return the optional
   */
  Optional<Tasks> findById(Long id);

  /**
   * Find all list.
   *
   * @return the list
   */
  List<Tasks> findAll();

  /**
   * Update optional.
   *
   * @param task the task
   * @return the optional
   */
  Optional<Tasks> update(Tasks task);

  /**
   * Delete by id boolean.
   *
   * @param id the id
   * @return the boolean
   */
  boolean deleteById(Long id);
}