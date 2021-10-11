package BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            switch (tokens.length) {
                case 1:
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    System.out.println(String.format("Account ID%d created",bankAccount.getId()));
                    break;
                case 2:
                    double interestRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case 3:
                    int id = Integer.parseInt(tokens[1]);
                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount bankAccount1 = bankAccounts.get(id);
                        if ("Deposit".equalsIgnoreCase(tokens[0])) {
                            double amount = Double.parseDouble(tokens[2]);
                            bankAccount1.deposit(amount);
                            System.out.println(String.format("Deposited %.0f to ID%d",amount,id));
                        } else {
                            int years = Integer.parseInt(tokens[2]);
                            System.out.println(String.format("%.2f",bankAccount1.getInterest(years)));
                        }
                    }
                    break;

            }

            command = scanner.nextLine();
        }
    }
}
