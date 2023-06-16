package Model;
import Model.Cards.Card;
import java.util.Random;
public class Account {
    private int accountNumber;

    private static  int Id_account=1000;
    private int pin;

    public static void setId_account(int id_account) {
        Id_account = id_account;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private int user_id;

    public Account(int pin, int user_id, String accountType, Card bankCard) {
        Random random = new Random();
        this.accountNumber = random.nextInt(90000) + 10000;
        this.pin = pin;
        this.user_id = user_id;
        this.accountType = accountType;
        BankCard = bankCard;
    }
    public Account(int accountNumber, int user_id, String accountType) {
        this.accountNumber = accountNumber;
        this.user_id = user_id;
        this.accountType = accountType;

    }

    private String accountType;
    private Card BankCard;



    public Account(){}

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getUser_id() {
        return user_id;
    }

    public Card getBankCard() {
        return BankCard;
    }

    public void setBankCard(Card bankCard) {
        BankCard = bankCard;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    public String getAccountType() {
        return accountType;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String toString(){
        String output="";
        if(this.BankCard!=null)
        {
         output="accountNumber: " + this.accountNumber + "\naccountType: " + this.accountType +
                "\nCard: "+this.BankCard.toString()+"\n";}
        else
        {
             output="accountNumber: " + this.accountNumber + "\naccountType: " + this.accountType +
                    "\nCard: not created yet";
        }
        return output;
    }


}