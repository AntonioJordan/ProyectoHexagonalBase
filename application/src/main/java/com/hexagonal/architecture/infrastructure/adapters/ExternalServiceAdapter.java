package com.hexagonal.architecture.infrastructure.adapters;

import com.hexagonal.architecture.domain.models.AdditionalTaskInfo;
import com.hexagonal.architecture.domain.ports.out.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * The type External service adapter.
 */
public class ExternalServiceAdapter implements ExternalServicePort {

  private final RestTemplate restTemplate;

  /**
   * Instantiates a new External service adapter.
   */
  public ExternalServiceAdapter() {
    restTemplate = new RestTemplate();
  }

  @Override
  public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
    String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
    ResponseEntity<JsonPlaceHolederTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolederTodo.class);
    JsonPlaceHolederTodo todo = response.getBody();
    if (todo == null) {
      return null;
    }
    apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
    ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
    JsonPlaceHolderUser user = userResponse.getBody();

    if (user == null) {
      return null;
    }
    return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
  }

  private static class JsonPlaceHolederTodo {
    private Long id;
    private Long userId;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
      return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
      this.id = id;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Long getUserId() {
      return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Long userId) {
      this.userId = userId;
    }
  }

  private static class JsonPlaceHolderUser {
    private Long id;
    private String name;
    private String email;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
      return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
      this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
      return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
      this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
      return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
      this.email = email;
    }
  }


}
