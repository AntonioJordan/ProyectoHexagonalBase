package com.hexagonal.architecture.infrastructure.config;

import com.hexagonal.architecture.application.services.AdditionalTaskInfoService;
import com.hexagonal.architecture.application.services.TaskService;
import com.hexagonal.architecture.application.usecases.CreateTaskUseCaseImpl;
import com.hexagonal.architecture.application.usecases.DeleteTaskUseCaseImpl;
import com.hexagonal.architecture.application.usecases.GetAdditionalTaskInfoUseCaseImpl;
import com.hexagonal.architecture.application.usecases.RetrieveTaskUseCaseImpl;
import com.hexagonal.architecture.application.usecases.UpdateTaskUseCaseImpl;
import com.hexagonal.architecture.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.architecture.domain.ports.out.ExternalServicePort;
import com.hexagonal.architecture.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.architecture.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.architecture.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Application config.
 */
@Configuration
public class ApplicationConfig {

  /**
   * Task service task service.
   *
   * @param taskRepositoryPort the task repository port
   * @param getAdditionalTaskInfoUseCase the get additional task info use case
   * @return the task service
   */
  @Bean
  public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
    return new TaskService(
        new CreateTaskUseCaseImpl(taskRepositoryPort),
        new RetrieveTaskUseCaseImpl(taskRepositoryPort),
        new UpdateTaskUseCaseImpl(taskRepositoryPort),
        new DeleteTaskUseCaseImpl(taskRepositoryPort),
        getAdditionalTaskInfoUseCase
    );
  }

  /**
   * Task repository port task repository port.
   *
   * @param jpaTaskRepositoryAdapter the jpa task repository adapter
   * @return the task repository port
   */
  @Bean
  public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
    return jpaTaskRepositoryAdapter;
  }

  /**
   * Gets additional task info use case.
   *
   * @param externalServicePort the external service port
   * @return the additional task info use case
   */
  @Bean
  public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(AdditionalTaskInfoService externalServicePort) {
    return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
  }

  /**
   * External service port external service port.
   *
   * @return the external service port
   */
  @Bean
  public ExternalServicePort externalServicePort() {
    return new ExternalServiceAdapter();
  }

}
