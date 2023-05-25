package Classes.Service;
import Classes.Account;
import Classes.Cards.Card;
import Classes.Cards.Credit;
import Classes.Cards.Debit;
import Classes.Cards.Savings;
import Classes.Customer;
import Classes.DatabaseConnection.*;
import Classes.Employee;
import Classes.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceClass {

    Scanner cin=new Scanner(System.in);

    CustomerDB customerDB=new CustomerDB();
    AccountDB accountDB=new AccountDB();
    CardDB cardDB=new CardDB();
    TransactionDB transactionDB = new TransactionDB();
    private ArrayList<Customer> customers=new ArrayList<Customer>();
    private ArrayList<Employee> employees=new ArrayList<Employee>();
    private ArrayList<Account> accounts=new ArrayList<Account>();

    public void AddCustomer()
    {
        System.out.println("Insert data for client:");

        System.out.print("Name");
        String name=cin.nextLine();

        System.out.print("ID:");
        String idd=cin.nextLine();
        LocalDate date = LocalDate.now();
        String stringdate =date.toString();
        System.out.print("Gender:");
        String gen=cin.nextLine();

        System.out.print("Marital:");
        String status=cin.nextLine();

        System.out.print("Address::");
        String address=cin.nextLine();

        System.out.print("City:");
        String city=cin.nextLine();

        System.out.print("PIN:");
        String pin=cin.nextLine();

        System.out.print("State:");
        String state=cin.nextLine();

        Customer client= new Customer(name,idd,stringdate,gen,status,address,city,pin,state);
        customers.add(client);
        customerDB.create(client);

    }
    public void PrintCustomers(){
        customers=  customerDB.read();
        for(Customer i:customers){
            System.out.println(i);
        }
    }

    public void DeleteCustomer(){
        System.out.println("What client would you like to delete? Insert id");
        int idd=cin.nextInt();
        customers=  customerDB.read();
        for(Customer i:customers){
            if(i.getId().equals(idd)){
                customerDB.delete(i);
            }
        }
        customers=  customerDB.read();

    }
    public void UpdateCustomer()
    {
        System.out.println("What client would you like to update? Insert id");
        int idd=cin.nextInt();
        customers=  customerDB.read();
        for(Customer i:customers){
            if(i.getId().equals(idd)){
                customerDB.update(i);
            }
        }
        customers=  customerDB.read();
    }
    public void PrintACustomer()
    {
        System.out.println("What client would you like to print? Insert id");
        int idd=cin.nextInt();
        customers=  customerDB.read();
        for(Customer i:customers){
            if(i.getId().equals(idd)){
                System.out.println(i);
            }
        }
    }
    public void CreateAccount()
    {
        ArrayList<Customer> clienti =customerDB.read();
        for (Customer i:clienti)
        {
            System.out.println(i);
        }
        System.out.println("Insert the client id for whom you want to create an account:");
        int id = cin.nextInt();
        System.out.printf("Creating account for :%d",id);
        Customer cus=null;
        for (Customer i:clienti)
        {
            if(Integer.parseInt(i.getId())==id)
            {
                cus=i;
            }
        }
        if(cus!=null)
        {
            System.out.println("Account number:");
            cin.nextLine();
            int acc_number= cin.nextInt();
            System.out.println("Account type:");
            cin.nextLine();
            String acc_type= cin.nextLine();


            Account acc=new Account(acc_number,Integer.parseInt(cus.getId()),acc_type);
            accountDB.create(acc,cus);
        }

    }
    public void CreateCard() throws SQLException {

        System.out.println("Insert the client id for which you want to make a card:");
        System.out.print("");
        int  id=cin.nextInt();
        Customer client=new Customer();
        ArrayList<Customer> customerss=customerDB.read();
        for(int i=0;i<customerss.size();i++)
        {
            if(Integer.parseInt(customerss.get(i).getId())==id)
            {
                client=customerss.get(i);
                System.out.println("Client gasit");
                System.out.print("");
            }
        }
        System.out.println("Configure the card:");
        System.out.print("Account Number: ");
        System.out.print("");
        int acc=cin.nextInt();
        Account contClient = null;

      ArrayList<Account> conturi =accountDB.read();
        for(Account i:conturi)
        {
            if(i.getAccountNumber()==acc)
            {
                contClient=i;
            }
        }
        Card cardNou = null;
       System.out.print("Card Type: (Savings, Credit or Card) ");
        System.out.print("");
       String type=cin.nextLine();
       if(contClient!=null) {

           if (contClient.getAccountType().equals("Savings")) {
                Savings cardd=new Savings();
               cardNou=cardd.readCard();
           }
           if (contClient.getAccountType().equals("Debit")) {

               cardNou.readCard();
           }
           if (contClient.getAccountType().equals("Credit")) {
               cardNou.readCard();
           }
       }
        cardDB.create(cardNou,client,contClient);
    }
    public void MakeTransaction(){
        System.out.println("Insert the client for which you want to make a transaction:");
        String name=cin.nextLine();
        Customer client=new Customer();
        for(int i=0;i<customers.size();i++)
        {
            if(customers.get(i).getName().equals(name))
            {
                client=customers.get(i);
            }
            else{ System.out.println("No such customer exist"); return;}
        }
        System.out.println("Insert the Account ID:");
        int input=cin.nextInt();
        Account contClientCurent= client.getAccountById(input);
        System.out.println("Press 1->Deposit  2->Withdrawl");
        input=cin.nextInt();
        if(input==1 || input==2)
        {
            if(input==1)
            {
                System.out.println("What amount do you want to deposit?");
                input=cin.nextInt();
                contClientCurent.getBankCard().depositMoney(input);
            }
            else
            {
                System.out.println("What amount do you want to withdrawl?");
                input=cin.nextInt();
                contClientCurent.getBankCard().withdrawlMoney(input);
            }

        }
        else System.out.println("Try again and insert 1->Deposit  2->Withdrawl");


    }
    public void AddTransactionToCard()
    {

        System.out.println("Insert the card number: ");
        System.out.print("");
        int id=cin.nextInt();
        Card card=cardDB.readCard(id);

        if(card==null){
            System.out.println("There is no such id");
            return;
        }
        else
            System.out.println("Insert the pin: ");
        System.out.print("");
        int pin=cin.nextInt();
        if(card.getSecurityCode()==pin)
        {
            System.out.println("Account verification succeded! Continue with transactions");
            System.out.println("Press 1->Deposit  2->Withdrawl");
            System.out.println("");
            int input=cin.nextInt();
            if(input==1 || input==2)
            {
                if(input==1)
                {
                    System.out.println("What amount do you want to deposit?");
                    System.out.println("");
                    double amou=cin.nextDouble();
                    Transaction tranz=new Transaction(Transaction.getId_tranzactie(),amou,"Deposit");
                    Card cardd=cardDB.readCard(id);
                    if(cardd!=null)
                    {


                    transactionDB.create(cardd,tranz);}
                }
                else
                {
                    System.out.println("What amount do you want to withdrawl?");
                    System.out.println("");
                    double amou=cin.nextDouble();
                    Transaction tranz=new Transaction(Transaction.getId_tranzactie(),amou,"Withdrawl");
                    transactionDB.create(cardDB.readCard(id),tranz);
                    Card cardul= cardDB.readCard(id);
                    if (cardul instanceof Savings) {
                        Savings save_card = (Savings) card;
                        save_card.withdrawlMoney(amou);
                        double final_balance=save_card.getBalance();
                        cardDB.update(final_balance,id);
                    }
                }

            }
            else System.out.println("Try again and insert 1->Deposit  2->Withdrawl");
        }
        else  System.out.println("Pin wrong acces denied");
    

    }

    public void PrintAccounts(){
        accounts=accountDB.read();
        for(Account i:accounts){
            System.out.println(i);
        }
    }

}
