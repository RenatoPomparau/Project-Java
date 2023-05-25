package Classes.DatabaseConnection;

import Classes.*;
import Classes.Cards.Card;
import Classes.Cards.Savings;

import javax.xml.transform.stax.StAXResult;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AccountDB {
    public ConnectionDB getConnection() {
        return connection;
    }

    ConnectionDB connection=new ConnectionDB();
    ArrayList<Account> accounts=new ArrayList<>();

    public ArrayList<Account> read(){
        ArrayList<Account> accounts = new ArrayList<>();
        try{

            ResultSet result = connection.s.executeQuery("SELECT * FROM Account");
            while(result.next()) {
                int  acc_id=result.getInt("account_number");
                int  user_id=result.getInt("user_id");
                String type=result.getString("account_type");
                Account account= new Account(acc_id,user_id,type);
                accounts.add(account);
            }
            connection.s.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return accounts;
    }
    public void create(Account account,Customer client){
        try{

            String query = "INSERT INTO Account (account_number,user_id,account_type) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = connection.c.prepareStatement(query);
            preparedStmt.setInt(1, account.getAccountNumber());
            preparedStmt.setString(2, client.getId());
            preparedStmt.setString(3, (account.getAccountType()));
            preparedStmt.execute();
            preparedStmt.close();

//            if(account.getAccountType().equals("Savings"))
//            {
//                CardDB cdb=new CardDB();
//                Card save=new Savings();
//                cdb.createSavings();
//            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
