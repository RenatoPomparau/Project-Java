package Classes.DatabaseConnection;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Classes.*;
import Classes.Cards.Card;
import Classes.Cards.Credit;
import Classes.Cards.Debit;
import Classes.Cards.Savings;
import com.opencsv.CSVWriter;
import javax.xml.transform.stax.StAXResult;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardDB {
    ConnectionDB connection=new ConnectionDB();
    ArrayList<Card> cards=new ArrayList<>();
    public Card readCard(int id) {

        try {
            String query = "SELECT * FROM Card c join Savings s on c.card_number=s.card_number where c.card_number=?";

            PreparedStatement preparedStmt = connection.c.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet result = preparedStmt.executeQuery();
            while (result.next()) {
                int cardNumber = result.getInt("card_number");
                int userId = result.getInt("user_id");
                int accNumber = result.getInt("acc_number");
                String cardHolderName = result.getString("card_holder_name");
                String expireDate = result.getString("expire_date");
                int securityCode = result.getInt("security_code");
                double balance = result.getInt("balance");
                double interest = result.getDouble("interest_rate");
                double percent = result.getDouble("percent_withdrawl");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(expireDate);
                Card card = new Savings(cardNumber, cardHolderName, date, securityCode, balance, interest, percent);
            return card;
            }
            preparedStmt.close();
            connection.s.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    return null;
    }
        public ArrayList<Card> read(){
        ArrayList<Account> accounts = new ArrayList<>();
        try{

            ResultSet result = connection.s.executeQuery("SELECT * FROM Card c join Savings s on c.card_number=s.card_number");
            ResultSet result1 = connection.s.executeQuery("SELECT * FROM Card c join Credit s on c.card_number=s.card_number");
            ResultSet result2 = connection.s.executeQuery("SELECT * FROM Card c join Debit s on c.card_number=s.card_number");
            while(result.next()) {
                int  cardNumber=result.getInt("card_number");
                int  userId=result.getInt("user_id");
                int  accNumber=result.getInt("acc_number");
                String  cardHolderName=result.getString("card_holder_name");
                String expireDate=result.getString("expire_date");
                int  securityCode=result.getInt("security_code");
                double  balance=result.getInt("balance");
                double interest=result.getDouble("interest_rate");
                double percent=result.getDouble("percent_withdrawl");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(expireDate);
                Card card= new Savings(cardNumber,cardHolderName,date,securityCode,balance,interest,percent);
                cards.add(card);
            }
            while(result1.next()) {
                int  cardNumber=result1.getInt("card_number");
                int  userId=result1.getInt("user_id");
                int  accNumber=result1.getInt("acc_number");
                String  cardHolderName=result1.getString("card_holder_name");
                String expireDate=result1.getString("expire_date");
                int  securityCode=result1.getInt("security_code");
                double  balance=result1.getInt("balance");
                double tax_percent=result1.getDouble("tax_percent");
                double left_to_pay=result1.getDouble("left_to_pay");
                double credit_limit=result1.getDouble("credit_limit");

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(expireDate);
                Card card= new Credit(cardNumber,cardHolderName,date,securityCode,balance,tax_percent);
                cards.add(card);
            }
            while(result2.next()) {
                int  cardNumber=result2.getInt("card_number");
                int  userId=result2.getInt("user_id");
                int  accNumber=result2.getInt("acc_number");
                String  cardHolderName=result2.getString("card_holder_name");
                String expireDate=result2.getString("expire_date");
                int  securityCode=result2.getInt("security_code");
                double  balance=result2.getInt("balance");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(expireDate);
                Card card= new Debit(cardNumber,cardHolderName,date,securityCode,balance);
                cards.add(card);
            }
            // + debit si credit
            connection.s.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return cards;
    }
    public void create(Card card,Customer client,Account cont) throws SQLException {
        try{
            System.out.println(card);
            String query = "INSERT INTO Card (card_number,user_id,acc_number,card_holder_name,expire_date,security_code,balance) VALUES (?, ?, ?,?,?,?,?)";
            PreparedStatement preparedStmt = connection.c.prepareStatement(query);
            preparedStmt.setInt(1, card.getCardNumber());
            preparedStmt.setInt(2, Integer.parseInt(client.getId()));
            preparedStmt.setInt(3, (cont.getAccountNumber()));
            preparedStmt.setString(4, client.getName());
            preparedStmt.setString(5, card.getExpirationDate().toString());
            preparedStmt.setInt(6, (card.getSecurityCode()));
            preparedStmt.setDouble(7, (card.getBalance()));
            preparedStmt.execute();
            preparedStmt.close();

            String selectSql = "SELECT * FROM Card WHERE card_number = ?";
            try (PreparedStatement selectStatement = connection.c.prepareStatement(selectSql)) {
                selectStatement.setInt(1, card.getCardNumber());
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    // Write data to CSV file
                    try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"))) {
                        writer.writeAll(resultSet, true);
                        System.out.println("Data written to CSV file successfully.");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            if (card instanceof Savings) {
                Savings save_card = (Savings) card;
                query = "INSERT INTO Savings (card_number,interest_rate,percent_withdrawl) values (?,?,?)";
                preparedStmt = connection.c.prepareStatement(query);
                preparedStmt.setInt(1, save_card.getCardNumber());
                preparedStmt.setDouble(2, save_card.getInterestRate());
                preparedStmt.setDouble(3, save_card.getPercentForWithdrawl());
                preparedStmt.execute();

                preparedStmt.close();
            }
            if (card instanceof Debit) {
                Debit debit_card = (Debit) card;
                query = "INSERT INTO Debit (card_number) values (?)";
                preparedStmt = connection.c.prepareStatement(query);
                preparedStmt.setInt(1, debit_card.getCardNumber());

                preparedStmt.execute();
                preparedStmt.close();
            }
            if (card instanceof Credit) {
                Credit credit_card = (Credit) card;
                query = "INSERT INTO Savings (card_number,tax_percent,left_to_pay,credit_limit) values (?,?,?,?)";
                preparedStmt = connection.c.prepareStatement(query);
                preparedStmt.setInt(1, credit_card.getCardNumber());
                preparedStmt.setDouble(2, credit_card.getTaxPercent());
                preparedStmt.setDouble(3, credit_card.getLeftToPay());
                preparedStmt.setDouble(4, credit_card.getCreditLimit());
                preparedStmt.execute();
                preparedStmt.close();
            }


        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void update(double balance, int card_no){
        try{
            String query = "UPDATE Card SET balance = ? WHERE card_number = ?";
            PreparedStatement preparedStmt = connection.c.prepareStatement(query);
            preparedStmt.setDouble(1,balance);
            preparedStmt.setInt(2, card_no);
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
