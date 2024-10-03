import object.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("John Doe");
        System.out.println("====== Mainpulating account balance ======");
        ba.deposit(100f);
        ba.withdraw(20.5f);
        ba.getTransactions();

        System.out.println("====== Closing account ======");
        ba.close();
        ba.deposit(200f);
        ba.getTransactions();
    }
}
