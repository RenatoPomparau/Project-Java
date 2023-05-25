package Classes;

import java.time.LocalDate;

import static java.lang.Double.compare;

public class Transaction implements Comparable<Transaction>{

    private int transactionId;
    private String date;
    private double amount;
    private String transactionType; //withdrawl deposit

    public static int getId_tranzactie() {
        return id_tranzactie;
    }

    private static int id_tranzactie;

    public Transaction(int transactionId, double amount, String transactionType) {
        LocalDate date = LocalDate.now();
        String dateString = date.toString();
        this.transactionId = transactionId;
        this.date = dateString;
        this.amount = amount;
        this.transactionType = transactionType;
        Transaction.id_tranzactie++;
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