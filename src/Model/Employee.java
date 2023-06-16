package Model;

import java.util.ArrayList;

public class Employee {
    private String name;
    private String position;

    public Employee(String name, String Position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void viewCustomerAccounts(Customer customer) {
        ArrayList<Account> accounts = customer.getAccounts();
        System.out.println("Accounts for " + customer.getName() + ":");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i).getAccountNumber());
        }
        System.out.printf("Employee %s created one account for %s\n", this.name, customer.getName());
    }

    public void deleteCustomerAccount(Customer customer, int id_cont) {
        ArrayList<Account> accounts = customer.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == id_cont) {
                accounts.remove(i);

            }
            customer.setAccounts(accounts);
            System.out.printf("Employee %s deleted one of %s's accounts\n", this.name, customer.getName());
        }
    }

//    public void createCustomerAccount(Customer customer, int id, String type) {
//        ArrayList<Account> accounts = customer.getAccounts();
//        Account cont = new Account(id, type);
//        accounts.add(cont);
//        customer.setAccounts(accounts);
//
//
//    }


    public void viewAccountTransactions(Customer customer, int id_cont) {
        ArrayList<Transaction> transactions = customer.getAccountById(id_cont).getBankCard().getTransactions();
        for(int i=0;i<transactions.size();i++)
        {
            System.out.println(transactions.get(i).toString());
        }
    }


}
//    public void addTransactionToAccount(Account account, Transaction transaction) {
//        account.addTransaction(transaction);
//        System.out.println("Added transaction: " + transaction);
//    }

//    public void removeTransactionFromAccount(Account account,int id_tranzactie) {
//        ArrayList<Transaction> tranzactii=account.getTransactions();
//        int pozitie=-1;
//        for(int i=0;i<tranzactii.size();i++)
//        {
//            if(tranzactii.get(i).getTransactionId()==id_tranzactie)
//            {
//                pozitie=i;
//            }
//        }
//        if(pozitie!=-1)
//        {
//            tranzactii.remove(pozitie);
//            System.out.println("Removed transaction");
//        }
//    else System.out.println("There is no such transaction for this account and this customer");
//
//
//    }

//    public void depositToAccount(Account account, double amount) {
////        LocalDate date = LocalDate.now();
////        String dateString = date.toString();
//        Transaction transaction = new Transaction(Transaction.Id_tranzactie, amount,"Deposit");
//        Transaction.Id_tranzactie+=1;
//        account.addTransaction(transaction);
//        System.out.println("Deposited " + amount + " to account " + account.getAccountNumber());
//    }

//    public void withdrawFromAccount(Account account, double amount) {
//        LocalDate date = LocalDate.now();
//        String dateString = date.toString();
//        Transaction transaction = new Transaction(Transaction.Id_tranzactie, amount,"Withdrawl");
//        account.addTransaction(transaction);
//        System.out.println("Withdrew " + amount + " from account " + account.getAccountNumber());
//    }
