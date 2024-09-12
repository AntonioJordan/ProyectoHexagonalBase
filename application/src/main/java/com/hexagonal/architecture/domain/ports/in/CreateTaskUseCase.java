package com.hexagonal.architecture.domain.ports.in;

import com.hexagonal.architecture.domain.models.Tasks;

public interface CreateTaskUseCase {
    Tasks createTask(Tasks task);
}
