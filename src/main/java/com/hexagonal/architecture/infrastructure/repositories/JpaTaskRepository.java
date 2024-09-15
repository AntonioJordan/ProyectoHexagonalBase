package com.hexagonal.architecture.infrastructure.repositories;

import com.hexagonal.architecture.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Jpa task repository.
 */
@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
