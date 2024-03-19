package com.hexagonal.architecture.application.usecases;

import com.hexagonal.architecture.domain.models.Tasks;
import com.hexagonal.architecture.application.ports.in.CreateTaskUseCase;
import com.hexagonal.architecture.application.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Tasks createTask(Tasks task) {
        return taskRepositoryPort.save(task);
    }
}
