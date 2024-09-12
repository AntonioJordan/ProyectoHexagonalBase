package com.hexagonal.architecture.infrastructure.repositories;

import com.hexagonal.architecture.domain.models.Tasks;
import com.hexagonal.architecture.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.architecture.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Tasks save(Tasks task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Tasks> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Tasks> findAll() {
        return jpaTaskRepository.findAll().stream().map(TaskEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Tasks> update(Tasks task) {
        if(jpaTaskRepository.existsById(task.getId())){
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updateTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updateTaskEntity.toDomainModel());
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaTaskRepository.existsById(id)){
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
