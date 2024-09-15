package com.hexagonal.architecture.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Additional task info.
 */
@Data
@AllArgsConstructor
public class AdditionalTaskInfo {
  private final Long userId;
  private final String userName;
  private final String userEmail;
}
