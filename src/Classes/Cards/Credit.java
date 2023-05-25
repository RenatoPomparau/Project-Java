package Classes.Cards;

import Classes.Cards.Card;
import Classes.Transaction;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Credit extends Card {
    public double getTaxPercent() {
        return TaxPercent;
    }

    public double getLeftToPay() {
        return leftToPay;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    private double TaxPercent;

    private double leftToPay;
    private double creditLimit;

    public Credit(int cardNumber, String cardHolderName, Date expirationDate, int securityCode,double balance ,double TaxPercent) {
        super(cardNumber, cardHolderName, expirationDate, securityCode,balance);
        this.TaxPercent=TaxPercent;
        this.leftToPay=0;
        this.creditLimit=100000;
    }
    public Credit(){super();}

    @Override
    public void depositMoney(double amount) {
        leftToPay -= amount;
        transactions.add(new Transaction(this.getId_tranzactie(),amount,"Payment for the credit"));
        increment_ID_transactie();
    }


    @Override
    public void withdrawlMoney(double amount) {

            leftToPay = leftToPay+amount+amount*TaxPercent/100;
            balance += amount;
            int transactie= this.getId_tranzactie();
            transactions.add(new Transaction(transactie,amount,"Credit"));
            increment_ID_transactie();
        }

    @Override
    public Credit readCard() {
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
        System.out.print("TaxPercent: ");
        input=cin.nextLine();
        this.TaxPercent=Integer.parseInt(input);
        System.out.println("Enter values for:");
        System.out.print("Limit for credit: ");
        input=cin.nextLine();
        this.creditLimit=Integer.parseInt(input);
        this.leftToPay=0;

        return this;
    }

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
                ", leftToPay=" + leftToPay +
                ", creditLimit=" + creditLimit + "\n"+Afisare_tranzactii()+
                '}';
    }


}

