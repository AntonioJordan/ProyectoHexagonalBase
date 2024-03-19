package com.hexagonal.architecture.application.ports.in;


import com.hexagonal.architecture.domain.models.Tasks;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Tasks> getTask(Long id);
    List<Tasks> getAllTasks();
}
