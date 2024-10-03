import object.BankAccount;
import object.FixedDepositAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("John Doe");
        System.out.println("====== Mainpulating account balance ======");
        ba.deposit(100f);
        ba.withdraw(20.5f);
        ba.getTransactions();

        System.out.println("====== Closing account ======");
        ba.close();
        //ba.deposit(200f);
        ba.getTransactions();

        System.out.println("====== Fixed Deposit Account ======");
        FixedDepositAccount fda = new FixedDepositAccount("Diana", 1000);
        fda.deposit(50f);
        fda.withdraw(20f);
        fda.getTransactions();
        System.out.println("FDA account balance: " + fda.getBalance());

        System.out.println("====== Changing FDA interest and duration ======");
        fda.setInterest(5f);
        fda.setDuration(10);
        //fda.setInterest(2f);
        //fda.setDuration(8);
        fda.close();
        fda.setBalance(300);
    }
}
