package Classes.Cards;
import Classes.Transaction;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Debit extends Card {

    public Debit(){
        super();
    }
    public Debit(int cardNumber, String cardHolderName, Date expirationDate, int securityCode,double balance) {
        super(cardNumber, cardHolderName, expirationDate, securityCode,balance);
    }




    @Override
    public void depositMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction(this.getId_tranzactie(),amount,"Deposit"));
        increment_ID_transactie();
    }
    @Override
    public void withdrawlMoney(double amount) {
        if (balance < amount){
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            int transactie= this.getId_tranzactie();
            transactions.add(new Transaction(transactie,amount,"Withdrawl"));
            increment_ID_transactie();;
        }
    }



    public Debit readCard()
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate=currentDate.plusYears(5);
        String input;
        Scanner cin=new Scanner(System.in);
        System.out.println("You have created a Debit Account!");
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
            sb.append(String.format("Transaction_ID: %s\nDate: %s\nType: %s\nAmount: %.2f\n\n",t.getTransactionId(), t.getDate(), t.getTransactionType(), t.getAmount()));
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
                ", balance=" + balance +  "\n"+Afisare_tranzactii()+
                '}';
    }



}


