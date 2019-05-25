package bank.app;

import bank.app.BankAccountInterface;

public class Bank {

    private BankAccountInterface[] bankAccounts = new BankAccountInterface[2];
    private int counter = 0;

    public void registerBankAccount(BankAccountInterface bankAccount) {
        if (!bankAccount.verifyCreditCard(bankAccount.getCreditCardNumber())) {
            System.out.println("Invalid Credit Card");
            return;
        }
        if (counter + 1 > bankAccounts.length) {
            dubleazaArray();
        }
        bankAccounts[counter] = bankAccount;
        counter++;
    }

    private void dubleazaArray() {
        BankAccountInterface[] newArray = new BankAccountInterface[bankAccounts.length * 2];
        for (int i = 0; i < bankAccounts.length; i++) {
            newArray[i] = bankAccounts[i];
        }

        bankAccounts = newArray;
    }

    public void deleteBankAccount(BankAccountInterface bankAccount) {
        int idFound = findAccount(bankAccount);
        if (idFound < 0) {
            System.out.println("Account not found");
            return;
        }

        for (int i = idFound; i < counter - 1; i++) {
            bankAccounts[i] = bankAccounts[i + 1];
        }
        System.out.println();
        bankAccounts[counter - 1] = null;
        counter--;
    }

    private int findAccount(BankAccountInterface bankaccount) {
        int start = 0;
        int end = counter - 1;

        BankAccountInterface target = bankaccount;

        while (start <= end) {
            int middle = (end + start) / 2;

            if (target.getId() == bankAccounts[middle].getId()) {
                return middle;
            } else if (target.getId() > bankAccounts[middle].getId()) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }

        }

        return -1;
    }

    public int getNumberOfTotalAccounts() {
        return counter;
    }

}
