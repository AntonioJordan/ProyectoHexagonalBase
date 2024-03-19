package com.hexagonal.architecture.application.usecases;

import com.hexagonal.architecture.domain.models.Tasks;
import com.hexagonal.architecture.application.ports.in.UpdateTaskUseCase;
import com.hexagonal.architecture.application.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort port;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort port) {
        this.port = port;
    }

    @Override
    public Optional<Tasks> updateTask(Long id, Tasks updateTask) {
        return port.update(updateTask);
    }
}
