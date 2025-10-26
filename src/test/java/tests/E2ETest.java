package tests;

import client.ApiClient;
import io.restassured.response.Response;
import models.requests.*;
import models.responses.PaymentsResponse;
import models.responses.UserRootResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.TestData.*;

public class E2ETest {
  private static ApiClient api;

  @BeforeAll
  public static void setup() {
    api = new ApiClient("http://localhost:8080");
  }

  @Test
  public void userFlowTest() {
    String email = "user" + System.currentTimeMillis() + "@test.com";
    String bookingDate = LocalDate.now().toString();

    // 1. Register new user
    UserRegistrationPayload registerUserBody = new UserRegistrationPayload(email, "12qw34er");
    Response registerResponse = api.registerUserRequest(registerUserBody);
    UserRootResponse registerUserResponse = registerResponse.as(UserRootResponse.class);

    assertEquals(200, registerResponse.getStatusCode());
    assertEquals(email, registerUserResponse.getUser().getEmail());
    assertEquals(SUCCESS_STATUS, registerUserResponse.getMessage().getStatus());
    assertEquals(REGISTERED_MESSAGE, registerUserResponse.getMessage().getMessage());

    // 2. Update user personal data
    String jsessionid = registerResponse.getCookie("JSESSIONID");
    PersonalDataPayload personalDataBody =
        new PersonalDataPayload(FIRST_NAME, SURNAME, PERSONAL_ID);
    Response personalDataResponse = api.addPersonalDataRequest(personalDataBody, jsessionid);
    UserRootResponse userPersonalDataResponse = personalDataResponse.as(UserRootResponse.class);

    assertEquals(201, personalDataResponse.getStatusCode());
    assertEquals(FIRST_NAME, userPersonalDataResponse.getUser().getFirstName());
    assertEquals(SUCCESS_STATUS, userPersonalDataResponse.getMessage().getStatus());
    assertEquals(PERSONAL_DATA_MESSAGE, userPersonalDataResponse.getMessage().getMessage());

    // 3. Add funds
    AddFundsPayload.Amount amountBody = new AddFundsPayload.Amount("EUR", FUNDS_AMOUNT);
    AddFundsPayload addFundsBody =
        new AddFundsPayload(
            FIRST_NAME + SURNAME,
            String.valueOf(PERSONAL_ID),
            TRANSACTION_TYPE,
            "1234",
            amountBody,
            bookingDate,
            "acc-123");
    Response addFundsResponse = api.addFundsRequest(addFundsBody, jsessionid);

    assertEquals(200, addFundsResponse.getStatusCode());
    assertTrue(addFundsResponse.asString().contains("Payment imported, id: "));

    // 4. Get balance with added funds
    Response getBalanceResponse = api.getUserBalanceRequest(jsessionid);
    double balance = Double.parseDouble(getBalanceResponse.asString());

    assertEquals(200, addFundsResponse.getStatusCode());
    assertEquals(FUNDS_AMOUNT, balance);

    // 5.Get payments list to see latest transaction
    Response getPaymentsResponse = api.getUserPaymentsListRequest(jsessionid);
    PaymentsResponse[] payments = getPaymentsResponse.as(PaymentsResponse[].class);
    PaymentsResponse latestPayment = payments[0];

    assertEquals(200, getPaymentsResponse.getStatusCode());
    assertEquals(TRANSACTION_TYPE, latestPayment.getType());
    assertEquals(FUNDS_AMOUNT, latestPayment.getAmount());
  }
}
