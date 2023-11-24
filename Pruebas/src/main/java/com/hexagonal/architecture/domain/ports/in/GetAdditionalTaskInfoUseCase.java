package com.hexagonal.architecture.domain.ports.in;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
