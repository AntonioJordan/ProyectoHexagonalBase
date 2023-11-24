package com.hexagonal.architecture.application.usercases;

import com.hexagonal.architecture.domain.models.Tasks;
import com.hexagonal.architecture.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.architecture.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort port;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort port) {
        this.port = port;
    }

    @Override
    public Optional<Tasks> getTask(Long id) {
        return port.findById(id);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return port.findAll();
    }
}
