package models.responses;

public class PaymentsResponse {
  private Integer id;
  private String type;
  private Double amount;
  private String rawResponse;

  public Integer getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public Double getAmount() {
    return amount;
  }

  public String getRawResponse() {
    return rawResponse;
  }
}
