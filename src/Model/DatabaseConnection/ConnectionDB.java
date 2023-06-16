package Model.DatabaseConnection;

import View.Conn;

import java.sql.*;
import java.sql.DriverManager;

public final class ConnectionDB {
    Connection c=null;
    private static ConnectionDB connectionDB=null;
    Statement s;
    public static ConnectionDB getInstance(){
        if(connectionDB==null)
        {
            connectionDB=new ConnectionDB();

        }
        return connectionDB;
    }
    private ConnectionDB(){
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
        Conn Conexiune =new Conn();

    }
}
