package com.hexagonal.architecture.domain.ports.out;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
