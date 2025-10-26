package models.requests;

public class PersonalDataPayload {
  public String firstName;
  public String surname;
  public Integer personalId;

  public PersonalDataPayload(String firstName, String surname, Integer personalId) {
    this.firstName = firstName;
    this.surname = surname;
    this.personalId = personalId;
  }
}
