package Classes.DatabaseConnection;

import java.sql.*;
import java.sql.DriverManager;

public class ConnectionDB {

    Connection c=null;
    Statement s;
    public ConnectionDB(){
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","renatop");
            s=c.createStatement();

            //  ResultSet rs=s.executeQuery("select * from signup");
            //  System.out.println(ResultSet.);
            if(c!=null)
            {
                System.out.println("Connected to DB");
            }
        }catch (Exception e){
            System.out.println("Not connected to DB");
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        bank.management.system.Conn Conexiune =new bank.management.system.Conn();

    }
}
