package Classes.DatabaseConnection;

import Classes.Account;
import Classes.Cards.Card;
import Classes.Cards.Credit;
import Classes.Cards.Debit;
import Classes.Cards.Savings;
import Classes.Customer;
import Classes.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TransactionDB {
    ConnectionDB connection=new ConnectionDB();
    ArrayList<Transaction> transactions=new ArrayList<>();

    public ArrayList<Transaction> read(){
        ArrayList<Account> accounts = new ArrayList<>();
        try{
            ResultSet result = connection.s.executeQuery("SELECT * FROM Transaction");
            while(result.next()) {
                int transaction_id = result.getInt("transaction_id");
                int card_id = result.getInt("card_id");
                double amount = result.getInt("amount");
                String transaction_type = result.getString("transaction_type");
                String transaction_date = result.getString("transaction_date");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(transaction_date);
                Transaction transaction = new Transaction(transaction_id,amount,transaction_type);
                transactions.add(transaction);
            }
            connection.s.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return transactions;
    }
    public void create(Card card, Transaction tranz){
        try{
            System.out.println(card);
            String query = "INSERT INTO Transaction VALUES (?, ?, ?,?,?)";
            PreparedStatement preparedStmt = connection.c.prepareStatement(query);
            preparedStmt.setInt(1, tranz.getTransactionId());
            preparedStmt.setInt(2, card.getCardNumber());
            preparedStmt.setDouble(3, (tranz.getAmount()));
            preparedStmt.setString(4, tranz.getDate().toString());
            preparedStmt.setString(5, tranz.getTransactionType());
            preparedStmt.execute();
            preparedStmt.close();
            connection.s.close();
            //update de balance in card based on other things.

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
