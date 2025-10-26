package models.requests;

public class AddFundsPayload {
  public String accountHolderFullName;
  public String accountHolderPersonalId;
  public String transactionType;
  public String investorId;
  public Amount amount;
  public String bookingDate;
  public String accountNumber;

  public AddFundsPayload(
      String accountHolderFullName,
      String accountHolderPersonalId,
      String transactionType,
      String investorId,
      Amount amount,
      String bookingDate,
      String accountNumber) {
    this.accountHolderFullName = accountHolderFullName;
    this.accountHolderPersonalId = accountHolderPersonalId;
    this.transactionType = transactionType;
    this.investorId = investorId;
    this.amount = amount;
    this.bookingDate = bookingDate;
    this.accountNumber = accountNumber;
  }

  public static class Amount {
    public String currency;
    public Double amount;

    public Amount(String currency, Double amount) {
      this.currency = currency;
      this.amount = amount;
    }
  }
}
