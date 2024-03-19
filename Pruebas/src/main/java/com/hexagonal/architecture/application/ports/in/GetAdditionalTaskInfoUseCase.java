package com.hexagonal.architecture.application.ports.in;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
