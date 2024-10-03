package object;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.lang.IllegalArgumentException;

public class BankAccount {
    private final String name;
    private final Integer num;
    private float balance;
    private List<String> log;
    private boolean isClosed;
    private LocalDateTime openDate;
    private LocalDateTime closeDate;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");

    public BankAccount(String name) {
        this.name = name;
        this.num = new Random().ints(100000000, 999999999).findAny().orElse(100000000);
        this.balance = 0.0f;
        this.log = new ArrayList<>();
        this.isClosed = false;
        this.openDate = LocalDateTime.now();
        this.closeDate = LocalDateTime.MAX;
    }

    public BankAccount(String name, float balance) {
        this.name = name;
        this.num = new Random().ints(100000000, 999999999).findAny().orElse(100000000);
        this.balance = balance;
        this.log = new ArrayList<>();
        this.isClosed = false;
        this.openDate = LocalDateTime.now();
        this.closeDate = LocalDateTime.MAX;
    }

    public void deposit(float value) {
        if (value < 0.0f) {
            throw new IllegalArgumentException("Value deposited is less than 0");
        } else if (isClosed == true) {
            throw new IllegalArgumentException("Account has been closed. Unable to perform operation.");
        }

        balance += value;
        log.add("deposit $" + String.format("%.2f", value) + " at " + LocalDateTime.now().format(DATE_FORMAT));
        System.out.println("$" + String.format("%.2f", value) + " deposited into account " + name);
    }

    public void withdraw(float value) {
        if (value < 0.0f) {
            throw new IllegalArgumentException("Value withdrawn is less than 0");
        } else if (isClosed == true) {
            throw new IllegalArgumentException("Account has been closed. Unable to perform operation.");
        }

        balance += value;
        log.add("withdraw $" + String.format("%.2f", value) + " at " + LocalDateTime.now().format(DATE_FORMAT));
        System.out.println("$" + String.format("%.2f", value) + " withdrawn from account " + name);
    }

    public void getTransactions() {
        System.out.println("------ " + num + " Account Log ------");
        for (String str : log) {
            System.out.println(str);
        }
    }

    public float getBalance() {
        return this.balance;
    }

    public String getName() {
        return name;
    }

    public Integer getNum() {
        return num;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public void close() {
        this.isClosed = true;
        closeDate = LocalDateTime.now();
    }

}
