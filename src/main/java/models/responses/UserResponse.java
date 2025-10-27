package models.responses;

public class UserResponse {
  public Integer id;
  public String email;
  public String firstName;
  public String surname;
  public String personalId;

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurname() {
    return surname;
  }

  public String getPersonalId() {
    return personalId;
  }
}
