public class Bank {

    private BankAccountInterface[] bankAccounts = new BankAccountInterface[2];
    private int counter = 0;

    public void registerBankAccount(BankAccountInterface bankAccount) {
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
            System.out.println("Bank Account not found");
            return;
        }

        for (int i = idFound-1; i < counter - 1; i++) {
            bankAccounts[i] = bankAccounts[i + 1];
        }
        System.out.println();
        bankAccounts[counter - 1] = null;
        counter--;
    }

    private int findAccount(BankAccountInterface bankaccount) {
        for (int i = 0; i < counter; i++) {
            if (bankAccounts[i] == bankaccount) {
                return bankAccounts[i].getId();
            }
        }

        return -1;
    }

    public int getNumberOfTotalAccounts() {
        System.out.println("Number of accounts registered is: ");
        return counter;
    }

    public void printAllAccounts(){
        for (int i = 0; i < bankAccounts.length; i++) {
            System.out.println(bankAccounts[i]);
        }
    }

}
