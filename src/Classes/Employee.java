package Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employee {
    private String name;
    private String position;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void viewCustomerAccounts(Customer customer) {
        ArrayList<Account> accounts = customer.getAccounts();
        System.out.println("Accounts for " + customer.getName() + ":");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i+1) + ". " + accounts.get(i).getAccountNumber());
        }
    }

    public void viewAccountTransactions(Account account) {
        ArrayList<Transaction> transactions = account.getTransactions();
        System.out.println("Transactions for account " + account.getAccountNumber() + ":");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }

    public void addTransactionToAccount(Account account, Transaction transaction) {
        account.addTransaction(transaction);
        System.out.println("Added transaction: " + transaction);
    }

    public void removeTransactionFromAccount(Account account,int id_tranzactie) {
        ArrayList<Transaction> tranzactii=account.getTransactions();
        int pozitie=-1;
        for(int i=0;i<tranzactii.size();i++)
        {
            if(tranzactii.get(i).getTransactionId()==id_tranzactie)
            {
                pozitie=i;
            }
        }
        if(pozitie!=-1)
        {
            tranzactii.remove(pozitie);
            System.out.println("Removed transaction");
        }
    else System.out.println("There is no such transaction for this account and this customer");


    }

    public void depositToAccount(Account account, double amount) {
//        LocalDate date = LocalDate.now();
//        String dateString = date.toString();
        Transaction transaction = new Transaction(Transaction.Id_tranzactie, amount,"Deposit");
        Transaction.Id_tranzactie+=1;
        account.addTransaction(transaction);
        System.out.println("Deposited " + amount + " to account " + account.getAccountNumber());
    }

    public void withdrawFromAccount(Account account, double amount) {
        LocalDate date = LocalDate.now();
        String dateString = date.toString();
        Transaction transaction = new Transaction(Transaction.Id_tranzactie, amount,"Withdrawl");
        account.addTransaction(transaction);
        System.out.println("Withdrew " + amount + " from account " + account.getAccountNumber());
    }
}