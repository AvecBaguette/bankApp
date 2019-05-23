package bank.app;

import bank.app.BankAccountInterface;
import bank.app.Currency;

public class BankAccount implements BankAccountInterface {
    private static int counter = 1;

    private int id;

    private String ownerName;

    private Currency currency;

    private double sold;

    public BankAccount() {

    }

    public BankAccount(String ownerName, Currency currency, double sold) {
        this.id = counter;
        counter++;

        this.currency = currency;
        this.ownerName = ownerName;
        this.sold = sold;
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

    public String toString() {
        return "BankAccount{ " +
                "id= " + id +
                ",ownerName= " + ownerName +
                ",currency= " + currency +
                ",sold= " + sold +
                " }";
    }
}
