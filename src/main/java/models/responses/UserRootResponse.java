package models.responses;

public class UserRootResponse {
  private UserResponse user;
  private MessageResponse message;

  public UserResponse getUser() {
    return user;
  }

  public MessageResponse getMessage() {
    return message;
  }
}
