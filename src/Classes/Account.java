package Classes;
import Classes.Cards.Card;
import Classes.Cards.Credit;
import Classes.Cards.Debit;
import Classes.Cards.Savings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
    private int accountNumber;

    public int getUser_id() {
        return user_id;
    }

    private int user_id;
    private String accountType;
    private Card BankCard;

    public Account(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;




    }
    public Account(){}
    public Account(int accountNumber,int user_id, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.user_id=user_id;
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
        String output="accountNumber: " + this.accountNumber + "\naccountType: " + this.accountType +
                "\nCard: "+this.BankCard.toString()+"\n";
        return output;
    }


}