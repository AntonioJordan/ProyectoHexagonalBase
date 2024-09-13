package com.hexagonal.architecture.domain.ports.out;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;

/**
 * The interface External service port.
 */
public interface ExternalServicePort {
  /**
   * Gets additional task info.
   *
   * @param taskId the task id
   * @return the additional task info
   */
  AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
