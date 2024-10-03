package object;

public class FixedDepositAccount extends BankAccount {
    private float interest;
    private int durationMonths;
    private boolean changedInterest;
    private boolean changedDuration;

    public FixedDepositAccount(String name, float balance) {
        super(name, balance);
        this.interest = 3;
        this.durationMonths = 6;
        this.changedInterest = false;
        this.changedDuration = false;
    }

    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
        this.durationMonths = 6;
        this.changedInterest = false;
        this.changedDuration = false;
    }

    public FixedDepositAccount(String name, float balance,float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.durationMonths = duration;
        this.changedInterest = false;
        this.changedDuration = false;
    }

    @Override
    public void deposit(float value) {
        System.out.println("Balance within fixed deposit account remains unchanged.");
    }

    @Override
    public void withdraw(float value) {
        System.out.println("Balance within fixed deposit account remains unchanged.");
    }

    @Override
    public float getBalance() {
        float bal = super.getBalance();
        float newBal = bal + interest;
        super.setBalance(newBal);
        // assuming that each call of getBalance() is for each interest period
        return newBal;
    }

    public void setInterest(float interest) {
        if (changedInterest == true) {
            throw new IllegalArgumentException("Interest has already been changed once");
        }
        this.interest = interest;
        this.changedInterest = true;
    }

    public void setDuration(int duration) {
        if (changedInterest == true) {
            throw new IllegalArgumentException("Duration has already been changed once");
        }
        this.durationMonths = duration;
        this.changedDuration = true;
    }
}
