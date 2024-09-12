package com.hexagonal.architecture.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
