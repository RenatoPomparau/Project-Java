package Model;

import java.time.LocalDate;
import java.util.Random;

public class Transaction implements Comparable<Transaction>{

    private int transactionId;
    private String date;
    private double amount;
    private String transactionType; //withdrawl deposit

    public static int getId_tranzactie() {
        return id_tranzactie;
    }

    private static int id_tranzactie;

    public Transaction(double amount, String transactionType) {
        Random random = new Random();
        this.transactionId = random.nextInt(90000) + 10000;
        LocalDate date = LocalDate.now();
        String dateString = date.toString();
        this.date = dateString;
        this.amount = amount;
        this.transactionType = transactionType;
    }
    @Override
    public int compareTo(Transaction other) {
        int x= this.transactionType.compareTo(other.transactionType);
        if(x>0)
        {
            return 1;
        }
        else
        if(x==0)
        {   return Integer.compare((int) this.amount, (int) other.amount);
        }
        return this.transactionType.compareTo(other.transactionType);
    }


    public int getTransactionId() {
        return transactionId;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }


}