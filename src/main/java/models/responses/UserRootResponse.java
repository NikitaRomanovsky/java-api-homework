package models.responses;

public class UserRootResponse {
  public UserResponse user;
  public MessageResponse message;

  public UserResponse getUser() {
    return user;
  }

  public MessageResponse getMessage() {
    return message;
  }
}
