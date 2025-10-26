package models.requests;

public class UserRegistrationPayload {
  public String email;
  public String password;

  public UserRegistrationPayload(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
