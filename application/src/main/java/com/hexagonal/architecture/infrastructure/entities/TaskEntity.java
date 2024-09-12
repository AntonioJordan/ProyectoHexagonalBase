package com.hexagonal.architecture.infrastructure.entities;

import com.hexagonal.architecture.domain.models.Tasks;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationdate;
    private boolean completed;

    public static TaskEntity fromDomainModel(Tasks task){
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.isCompleted());
    }

    public Tasks toDomainModel(){
        return new Tasks(id, title, description, creationdate, completed);
    }

}
