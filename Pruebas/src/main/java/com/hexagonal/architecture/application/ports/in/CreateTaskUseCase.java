package com.hexagonal.architecture.application.ports.in;

import com.hexagonal.architecture.domain.models.Tasks;

public interface CreateTaskUseCase {
    Tasks createTask(Tasks task);
}
