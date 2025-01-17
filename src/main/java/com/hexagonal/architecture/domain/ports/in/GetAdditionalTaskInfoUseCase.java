package com.hexagonal.architecture.domain.ports.in;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;

/**
 * The interface Get additional task info use case.
 */
public interface GetAdditionalTaskInfoUseCase {
  /**
   * Gets additional task info.
   *
   * @param id the id
   * @return the additional task info
   */
  AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
