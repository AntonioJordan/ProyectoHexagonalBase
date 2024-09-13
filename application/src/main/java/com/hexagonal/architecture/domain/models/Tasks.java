package com.hexagonal.architecture.domain.models;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Tasks.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
  private Long id;
  private String title;
  private String description;
  private LocalDateTime creationDate;
  private boolean completed;

}
