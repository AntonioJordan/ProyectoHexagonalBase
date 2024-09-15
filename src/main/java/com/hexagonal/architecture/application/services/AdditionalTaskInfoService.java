package com.hexagonal.architecture.application.services;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.architecture.domain.ports.out.ExternalServicePort;
import org.springframework.stereotype.Service;

/**
 * The type Additional task info service.
 */
@Service
public class AdditionalTaskInfoService implements GetAdditionalTaskInfoUseCase {

  private final ExternalServicePort externalServicePort;

  /**
   * Instantiates a new Additional task info service.
   *
   * @param externalServicePort the external service port
   */
  public AdditionalTaskInfoService(ExternalServicePort externalServicePort) {
    this.externalServicePort = externalServicePort;
  }

  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
    return externalServicePort.getAdditionalTaskInfo(id);
  }
}
