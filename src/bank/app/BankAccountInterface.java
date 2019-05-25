package bank.app;

public interface BankAccountInterface {

    int getId();

    boolean verifyCreditCard(String creditCardNumber);

    String getCreditCardNumber();
}
