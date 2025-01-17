package com.hexagonal.architecture.infrastructure.entities;

import com.hexagonal.architecture.domain.models.Tasks;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * The type Task entity.
 */
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

  /**
   * From domain model task entity.
   *
   * @param task the task
   * @return the task entity
   */
  public static TaskEntity fromDomainModel(Tasks task) {
    return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.isCompleted());
  }

  /**
   * To domain model tasks.
   *
   * @return the tasks
   */
  public Tasks toDomainModel() {
    return new Tasks(id, title, description, creationdate, completed);
  }

}
