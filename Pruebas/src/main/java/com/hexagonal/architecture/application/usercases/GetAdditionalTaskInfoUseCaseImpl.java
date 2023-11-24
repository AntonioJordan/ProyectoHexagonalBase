package com.hexagonal.architecture.application.usercases;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.architecture.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort port;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort port) {
        this.port = port;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return port.getAdditionalTaskInfo(id);
    }
}
