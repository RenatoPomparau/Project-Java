package Classes.Cards;

import Classes.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class Card {

    private static  int Id_tranzactie=1000;
    protected int cardNumber;
    protected String cardHolderName;

    public Date getExpirationDate() {
        return expirationDate;
    }

    protected Date expirationDate;

    public int getSecurityCode() {
        return securityCode;
    }

    protected int securityCode;

    public double getBalance() {
        return balance;
    }

    protected double balance;
    protected ArrayList<Transaction> transactions;
    public Card(){}
    public Card(int cardNumber, String cardHolderName, Date expirationDate, int securityCode, double balance) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.balance=balance;
        this.transactions=new ArrayList<Transaction>();
    }
    public ArrayList<Transaction> getTransactions(){return transactions;}

    public  int getId_tranzactie() //pentru a memora intr-o ordine tranzactiile.
    {
        return Id_tranzactie;
    }
    public void increment_ID_transactie()
    {
         Id_tranzactie+=1;
    }


    public abstract void depositMoney(double amount);
    public abstract void withdrawlMoney(double amount);

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getCardNumber(){return this.cardNumber;}
    public abstract Card readCard();

    public abstract String Afisare_tranzactii();


    public abstract void sortTranzactionsByAmount();
}
