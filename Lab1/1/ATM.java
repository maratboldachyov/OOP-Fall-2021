import java.math.BigDecimal;
import java.util.Scanner;

public class ATM<T extends Account>{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose account type:\n1)Regular\n2)Golden\n3)Premium");
            int choice = scan.nextInt();

        while(choice!=1 && choice!= 2 && choice!=3){
            System.out.println("Please, try again: ");
            choice = scan.nextInt();
        }

        System.out.print("Enter your account number: ");
        String number = scan.next();
        System.out.print("Enter your name: ");
        String name = scan.next();
        System.out.print("Enter your current balance: ");
        String balance = scan.next();
        switch (choice){
            case 1 : {
                RegularAccount account = new RegularAccount(number, new Client(name), new BigDecimal(balance));
                System.out.println("\nChoose operation:\n1)Credit\n2)Debit\n3)Withdraw\n4)Deposit");

                int operation = scan.nextInt();

                ATM<RegularAccount> atm = new ATM<>();

                switch (operation){
                    case 1: {
                        System.out.print("Enter the amount of money to credit: ");
                        String amount = scan.next();
                        account.credit(new BigDecimal(amount));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the amount of money to debit: ");
                        String amount = scan.next();
                        account.debit(new BigDecimal(amount));
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the amount of money to withdraw: ");
                        String amount = scan.next();

                        atm.withdraw(account, new BigDecimal(amount));
                        break;
                    }
                    case 4: {
                        System.out.println("Enter the amount of money to deposit: ");
                        String amount = scan.next();
                        atm.deposit(account, new BigDecimal(amount));
                        break;
                    }
                }
                break;
            }
            case 2 : {
                GoldenAccount account = new GoldenAccount(number, new Client(name), new BigDecimal(balance));

                System.out.println("\nChoose operation:\n1)Credit\n2)Debit\n3)Withdraw\n4)Deposit");

                int operation = scan.nextInt();

                ATM<GoldenAccount> atm = new ATM<>();

                switch (operation){
                    case 1: {
                        System.out.print("Enter the amount of money to credit: ");
                        String amount = scan.next();
                        account.credit(new BigDecimal(amount));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the amount of money to debit: ");
                        String amount = scan.next();
                        account.debit(new BigDecimal(amount));
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the amount of money to withdraw: ");
                        String amount = scan.next();

                        atm.withdraw(account, new BigDecimal(amount));
                        break;
                    }
                    case 4: {
                        System.out.println("Enter the amount of money to deposit: ");
                        String amount = scan.next();
                        atm.deposit(account, new BigDecimal(amount));
                        break;
                    }
                }
                break;
            }
            case 3 : {
                PremiumAccount account = new PremiumAccount(number, new Client(name), new BigDecimal(balance));

                System.out.println("\nChoose operation:\n1)Credit\n2)Debit\n3)Withdraw\n4)Deposit");

                int operation = scan.nextInt();

                ATM<PremiumAccount> atm = new ATM<>();

                switch (operation){
                    case 1: {
                        System.out.print("Enter the amount of money to credit: ");
                        String amount = scan.next();
                        account.credit(new BigDecimal(amount));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the amount of money to debit: ");
                        String amount = scan.next();
                        account.debit(new BigDecimal(amount));
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the amount of money to withdraw: ");
                        String amount = scan.next();

                        atm.withdraw(account, new BigDecimal(amount));
                        break;
                    }
                    case 4: {
                        System.out.println("Enter the amount of money to deposit: ");
                        String amount = scan.next();
                        atm.deposit(account, new BigDecimal(amount));
                        break;
                    }
                }
                break;
            }
        }

    }
    public void withdraw(T account, BigDecimal amount){
        if(amount.compareTo(account.balance) > 0){
            System.out.println("Request canceled, insufficient funds");
        }
        else {
            account.balance = account.balance.subtract(amount);
            System.out.println("Account number: "+account.accountNumber);
            System.out.println("Client name: "+account.ownerName.name);
            System.out.println("Withdrawal amount: "+amount.toString());
            System.out.println("Balance: "+account.balance.toString());
        }
    }

    public void deposit(T account, BigDecimal amount){
        account.balance = account.balance.add(amount);
        System.out.println("Account number: "+account.accountNumber);
        System.out.println("Client name: "+account.ownerName.name);
        System.out.println("Deposit amount: "+amount.toString());
        System.out.println("Balance: "+account.balance.toString());
    }
}
