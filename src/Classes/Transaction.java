package Classes;

import java.time.LocalDate;

public class Transaction {
    static  int Id_tranzactie=1000;
    private int transactionId;
    private String date;
    private double amount;
    private String transactionType; //withdrawl deposit

    public Transaction(int transactionId, double amount, String transactionType) {
        LocalDate date = LocalDate.now();
        String dateString = date.toString();
        this.transactionId = transactionId;
        this.date = dateString;
        this.amount = amount;
        this.transactionType = transactionType;
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
}