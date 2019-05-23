import bank.app.Bank;
import bank.app.BankAccount;
import bank.app.Currency;

public class Test {
    public static void main(String[] args) {
        BankAccount EURacc = new BankAccount("AvecBaguette", Currency.EUR, 2000);
        BankAccount USDacc = new BankAccount("Trump", Currency.USD, 1046);
        BankAccount YENacc = new BankAccount("Naruto Uzumaki", Currency.YEN, 50356);
        BankAccount RONacc = new BankAccount("Popescu", Currency.RON, 10);

        Bank noNameBank = new Bank();

        noNameBank.registerBankAccount(EURacc);
        noNameBank.registerBankAccount(USDacc);
        noNameBank.registerBankAccount(YENacc);
        noNameBank.registerBankAccount(RONacc);

        System.out.println(noNameBank.getNumberOfTotalAccounts());

        noNameBank.deleteBankAccount(EURacc);

        System.out.println(noNameBank.getNumberOfTotalAccounts());


        System.out.println(YENacc);
        YENacc.depositMoney(69, Currency.RON);
        System.out.println(YENacc);

        YENacc.withdrawMoney(40, Currency.USD);
        System.out.println(YENacc);

        System.out.println(EURacc);
        EURacc.withdrawMoney(2000);
        System.out.println(EURacc);

        YENacc.withdrawMoney(60000);

        EURacc.depositMoney(1);
        System.out.println(EURacc);

        BankAccount newAcc = new BankAccount("asdasd", Currency.EUR, 2000);
        noNameBank.registerBankAccount(newAcc);

        System.out.println(noNameBank.getNumberOfTotalAccounts());

        System.out.println(newAcc);

        noNameBank.deleteBankAccount(newAcc);


        BankAccount newAcc2 = new BankAccount("asdasd", Currency.EUR, 2000);

        noNameBank.deleteBankAccount(newAcc2);

        EURacc.withdrawMoney(123123);
    }

}
