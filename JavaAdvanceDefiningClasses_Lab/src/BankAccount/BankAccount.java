package BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02d;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount;
    private int id;
    private double balance;


    public BankAccount() {
        this.id = ++bankAccountCount;

    }

    public static void setInterestRate(double interestRate) {
        BankAccount.rate = interestRate;
    }

    public double getInterest(int years) {
        return BankAccount.rate * years * this.balance;
    }

    public int getId() {
        return this.id;
    }
    public void deposit(double amount){
        this.balance +=amount;
    }


}
