package com.hexagonal.architecture.application.services;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.application.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.architecture.application.ports.out.ExternalServicePort;
import org.springframework.stereotype.Service;

@Service
public class AdditionalTaskInfoService implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public AdditionalTaskInfoService(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
