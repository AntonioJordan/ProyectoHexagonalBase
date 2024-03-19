package com.hexagonal.architecture.application.ports.out;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
