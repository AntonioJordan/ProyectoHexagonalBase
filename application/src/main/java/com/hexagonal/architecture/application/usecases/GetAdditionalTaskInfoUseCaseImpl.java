package com.hexagonal.architecture.application.usecases;

import com.hexagonal.architecture.application.services.AdditionalTaskInfoService;
import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.architecture.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final AdditionalTaskInfoService additionalTaskInfoService;

    public GetAdditionalTaskInfoUseCaseImpl(AdditionalTaskInfoService additionalTaskInfoService) {
        this.additionalTaskInfoService = additionalTaskInfoService;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return additionalTaskInfoService.getAdditionalTaskInfo(id);
    }
}
