package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.requests.AddFundsPayload;
import models.requests.PersonalDataPayload;
import models.requests.UserRegistrationPayload;

public class ApiClient {
  private final String baseUri;

  public ApiClient(String baseUri) {
    this.baseUri = baseUri;
  }

  public Response registerUserRequest(UserRegistrationPayload body) {
    return RestAssured.given()
        .baseUri(baseUri)
        .contentType("application/json")
        .body(body)
        .when()
        .post("/public/sign-up")
        .then()
        .log()
        .all()
        .extract()
        .response();
  }

  public Response addPersonalDataRequest(PersonalDataPayload body, String jsessionid) {
    return RestAssured.given()
        .baseUri(baseUri)
        .contentType("application/json")
        .cookie("JSESSIONID", jsessionid)
        .body(body)
        .when()
        .post("/api/personal-data")
        .then()
        .log()
        .all()
        .extract()
        .response();
  }

  public Response addFundsRequest(AddFundsPayload body, String jsessionid) {
    return RestAssured.given()
        .baseUri(baseUri)
        .contentType("application/json")
        .cookie("JSESSIONID", jsessionid)
        .body(body)
        .when()
        .post("/api/add-funds")
        .then()
        .log()
        .all()
        .extract()
        .response();
  }

  public Response getUserBalanceRequest(String jsessionid) {
    return RestAssured.given()
        .baseUri(baseUri)
        .contentType("application/json")
        .cookie("JSESSIONID", jsessionid)
        .when()
        .get("/api/balance")
        .then()
        .log()
        .all()
        .extract()
        .response();
  }

  public Response getUserPaymentsListRequest(String jsessionid) {
    return RestAssured.given()
        .baseUri(baseUri)
        .contentType("application/json")
        .cookie("JSESSIONID", jsessionid)
        .when()
        .get("/api/payments")
        .then()
        .log()
        .all()
        .extract()
        .response();
  }
}
