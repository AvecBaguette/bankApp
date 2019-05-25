package bank.app;

import bank.app.BankAccountInterface;
import bank.app.Currency;

public class BankAccount implements BankAccountInterface {
    private static int counter = 1;

    private String creditCardNumber;
    private int id;

    private String ownerName;

    private Currency currency;

    private double sold;

    public BankAccount() {

    }

    public BankAccount(String ownerName, Currency currency, double sold, String creditCardNumber) {
        this.id = counter;
        counter++;
        this.currency = currency;
        this.ownerName = ownerName;
        this.sold = sold;
        this.creditCardNumber = creditCardNumber;
    }

    public boolean verifyCreditCard(String creditCardNumber) {
        if (creditCardNumber.length() < 13 || creditCardNumber.length() > 16) {
            return false;
        }
        char[] cardNumberCharArray = creditCardNumber.toCharArray();

        int[] cardNumberIntArray = new int[16];


        for (int i = 0; i < cardNumberCharArray.length; i++) {
            cardNumberIntArray[i] = cardNumberCharArray[i] - 48;
        }

        if (cardNumberIntArray[0] != 4 && cardNumberIntArray[0] != 5 && cardNumberIntArray[0] != 6 && (cardNumberIntArray[0] != 3 && cardNumberIntArray[1] != 7)) {
            return false;
        }
        int digitSum = 0;
        for (int i = cardNumberIntArray.length - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                digitSum += doubleDigit(cardNumberIntArray[i]);
            } else {

                digitSum += cardNumberIntArray[i];
            }
        }

        if (digitSum % 10 == 0) {
            return true;
        }

        return false;
    }

    private int doubleDigit(int digit) {
        int sum = digit * 2;

        if (sum / 10 != 0) {
            sum = sum % 10 + (sum / 10) % 10;
        }

        return sum;
    }


    public void depositMoney(double sum) {
        if (sum < 0) {
            System.out.println("Invalid value");
            return;
        }
        this.sold += sum;
    }

    public void depositMoney(double sum, Currency currency) {
        double newSum = convertCurrency(sum, currency);
        depositMoney(newSum);
    }

    private double convertCurrency(double sum, Currency currency) {
        if (currency == this.currency) {
            return sum;
        }

        double USDsum = currency.convertToUSD(sum);
        sum = this.currency.convertFromUSD(USDsum);

        return sum;

    }

    public void withdrawMoney(double sum) {
        if (sum < 0) {
            System.out.println("Invalid value");
            return;
        }

        if (sum > this.sold) {
            System.out.println("Not enough money in the account");
            return;
        }

        System.out.println("Withdrawn: " + sum + " " + currency + " from " + ownerName);
        this.sold -= sum;
    }

    public void withdrawMoney(double sum, Currency currency) {
        double newSum = convertCurrency(sum, currency);
        withdrawMoney(newSum);
    }


    public int getId() {
        return id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String toString() {
        return "BankAccount{ " +
                "id= " + id +
                ",ownerName= " + ownerName +
                ",currency= " + currency +
                ",sold= " + sold +
                " }";
    }
}
