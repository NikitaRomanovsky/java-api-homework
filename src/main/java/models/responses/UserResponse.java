package models.responses;

public class UserResponse {
  public Integer id;
  public String email;
  public Object firstName;
  public Object surname;
  public Object personalId;

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public Object getFirstName() {
    return firstName;
  }

  public Object getSurname() {
    return surname;
  }

  public Object getPersonalId() {
    return personalId;
  }
}
