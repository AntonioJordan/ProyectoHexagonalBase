package com.hexagonal.architecture.application.ports.in;


import com.hexagonal.architecture.domain.models.Tasks;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Tasks> updateTask(Long id, Tasks updateTask);
}
