package com.hexagonal.architecture.application.usecases;

import com.hexagonal.architecture.application.services.AdditionalTaskInfoService;
import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.architecture.domain.ports.out.ExternalServicePort;

/**
 * The type Get additional task info use case.
 */
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

  private final AdditionalTaskInfoService additionalTaskInfoService;

  /**
   * Instantiates a new Get additional task info use case.
   *
   * @param additionalTaskInfoService the additional task info service
   */
  public GetAdditionalTaskInfoUseCaseImpl(AdditionalTaskInfoService additionalTaskInfoService) {
    this.additionalTaskInfoService = additionalTaskInfoService;
  }

  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
    return additionalTaskInfoService.getAdditionalTaskInfo(id);
  }
}
