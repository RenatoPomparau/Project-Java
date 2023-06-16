package Model.Cards;
import java.time.LocalDate;
import Model.Transaction;

import java.util.*;

public class Savings extends Card {

    public double getInterestRate() {
        return interestRate;
    }

    public double getPercentForWithdrawl() {
        return PercentForWithdrawl;
    }

    protected double interestRate;
    protected double PercentForWithdrawl;
    public Savings(){
        super();
    }

    public Savings(int cardNumber, String cardHolderName, Date expirationDate, int securityCode,double balance,double interestRate,double PercentForWithdrawl) {
        super(cardNumber, cardHolderName, expirationDate, securityCode, balance);
        this.interestRate = interestRate;
        this.PercentForWithdrawl=PercentForWithdrawl;
    }
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
        this.balance=balance;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }


    @Override
    public void depositMoney(double amount) {
        balance += amount;
        if (transactions==null)
            transactions=new ArrayList<Transaction>();
        Transaction tranzactie=new Transaction(amount,"Deposit");
        increment_ID_transactie();
        this.transactions.add(tranzactie);
    }
    public void addInterestRate() {
        balance += balance*(interestRate/100);
        transactions.add(new Transaction(balance*(interestRate/100),"Interest Rate Deposit"));
        increment_ID_transactie();
    }

    @Override
    public void withdrawlMoney(double amount) {
        if (balance < amount+amount*(PercentForWithdrawl/100) ){
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            balance -= amount*(PercentForWithdrawl/100);
            int transactie= this.getId_tranzactie();
            if (transactions==null)
                transactions=new ArrayList<Transaction>();
           // Transaction tranzacite=new Transaction(increment(this.getId_tranzactie()),amount,"Deposit");
            transactions.add(new Transaction(amount,"Withdrawl"));
            increment_ID_transactie();
            transactions.add(new Transaction(amount*(PercentForWithdrawl/100),"Withdrawl tax penalty"));
            increment_ID_transactie();
        }
    }


    public Savings readCard()
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate=currentDate.plusYears(5);
        String input;
        Scanner cin=new Scanner(System.in);
        System.out.println("You have created a Savings Account!");
        System.out.println("-----------------------------------");
        System.out.println("Enter values for:");
        System.out.print("cardNumber: ");
         input=cin.nextLine();
        this.setCardNumber(Integer.parseInt(input));
        System.out.println("Enter values for:");
        System.out.print("cardHolderName: ");
        input=cin.nextLine();
        this.setCardHolderName(input);
        this.setExpirationDate(java.sql.Date.valueOf(futureDate));
        System.out.println("Enter values for:");
        System.out.print("securityCode: ");
        input=cin.nextLine();
        this.setSecurityCode(Integer.parseInt(input));
        System.out.println("Enter values for:");
        System.out.print("balance: ");
        input=cin.nextLine();
        this.setBalance(Integer.parseInt(input));
        System.out.println("Enter values for:");
        System.out.print("interestRate: ");
        input=cin.nextLine();
        this.interestRate=Integer.parseInt(input);
        System.out.println("Enter values for:");
        System.out.print("PercentForWithdrawl: ");
        input=cin.nextLine();
        this.PercentForWithdrawl=Integer.parseInt(input);

        return this;
    }

    @Override
    public String Afisare_tranzactii() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(transactions);
        if(transactions==null)
            return "There are no transactions";
        sb.append("Card transactions:\n");
        for (Transaction t : transactions) {
            sb.append(String.format("Transaction_ID: %s\nDate: %s\nType: %s\nAmount: %.2f\n",t.getTransactionId(), t.getDate(), t.getTransactionType(), t.getAmount()));
        }
        return sb.toString();
    }

    @Override
    public void sortTranzactionsByAmount() {
        Collections.sort(transactions);
    }


    public String toString()
    {
        return "Savings{" +
                "cardNumber=" + cardNumber +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expirationDate=" + expirationDate +
                ", securityCode=" + securityCode +
                ", balance=" + balance +
                ", interestRate=" + interestRate    +'}';
               // ", PercentForWithdrawl=" + PercentForWithdrawl + "\n"+Afisare_tranzactii()+

    }



    }



