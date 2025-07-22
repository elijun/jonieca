package Pistan_Banking_App;

import java.util.Scanner;

public class pistan {
    public static void main(String[] args) {
        Scanner ScanAccount = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = {
                new Account("Magdalena", 45000, 1234),
                new Account("Eli", 340007, 1052),
                new Account("Jenny", 150212, 8910),
                new Account("Kazandra", 900111, 6500)
        };

        Account currentUser = null;
        boolean runProgram = true;

        while (runProgram) {
            boolean auth = false;
            boolean found = false;
            String accountName;
            int accountPin;

            while (!auth) {
                System.out.println("==============================================");
                System.out.println("|                                            |");
                System.out.println("|     Welcome to Pistan United Bank 💸       |");
                System.out.println("|                                            |");
                System.out.println("|  \"Buti pa yung iba mataba ang wallet,      |");
                System.out.println("|   Samantalang ako eto, mataba lang.\" 😔    |");
                System.out.println("|                                            |");
                System.out.println("==============================================");


                System.out.print("Enter Account Pin: ");

                accountPin = ScanAccount.nextInt();

                for (Account acc : accounts) {
                    if (acc.pin == accountPin) {
                        auth = true;
                        System.out.println("Authorized");
                        currentUser = acc;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Account does not exist.");
                }
            }

            boolean signout = true;

            while (signout) {
                System.out.println("----------------------------");
                System.out.println("Welcome " + currentUser.name + " | Banking App |");
                System.out.println("----------------------------");
                System.out.println("1. Balance " + "( $" + currentUser.balance + " )");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Money Transfer");
                System.out.println("5. Exit");
                System.out.println("6. Sign out");
                System.out.println("----------------------------");
                System.out.print("Enter Number: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println(currentUser.name + "> BALANCE: $" + currentUser.balance);
                        PressToContinue();
                    }
                    case 2 -> {
                        System.out.print("Enter Amount to deposit: ");
                        double amount = scanner.nextDouble();
                        currentUser.deposit(amount);
                        PressToContinue();
                    }
                    case 3 -> {
                        System.out.print("Enter Amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        currentUser.withdraw(amount);
                        PressToContinue();
                    }

                    case 4 -> {
                        boolean usertransfer = false;
                        Account selecterUser;
                        System.out.print("Enter Name:");
                        Scanner transfer = new Scanner(System.in);
                        accountName = transfer.nextLine();
                        for (Account accTransfer : accounts) {
                            if (accTransfer.name.equalsIgnoreCase(accountName)) {
                                selecterUser = accTransfer;
                                System.out.print("Enter amount to transfer to " + accountName +":");
                                Scanner moneytotransfer = new Scanner(System.in);
                                double amount = moneytotransfer.nextDouble();
                                selecterUser.deposit(amount);
                                currentUser.withdraw(amount);
                                System.out.println(amount + "$ transfered to " + accountName);
                                usertransfer = true;
                                PressToContinue();
                                break;
                            }
                        }

                        if (!usertransfer) {
                            System.out.println("Account does not exist.");
                            PressToContinue();
                        }
                    }

                    case 5 -> {
                        runProgram = false;
                        signout = false;
                    }
                    case 6 -> {
                        signout = false;
                        System.out.println("Signed out.");
                        PressToContinue();
                    }

                    default -> System.out.println("Invalid Choice");
                }
            }
        }

        ScanAccount.close();
        scanner.close();
    }

    public static void PressToContinue(){
        Scanner confirm = new Scanner(System.in);
        System.out.print("press enter to continue...");
        String cont = confirm.nextLine();
    }
}
//METHOSD

class Account {
    double balance;
    String name;
    int pin;

    public Account(String name, double balance, int pin) {
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
        }
    }
}
