package Classes.DatabaseConnection;

import Classes.*;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB {
    ConnectionDB connection=new ConnectionDB();
    ArrayList<Customer> customers=new ArrayList<>();

    public ArrayList<Customer> read(){
        ArrayList<Customer> customers = new ArrayList<>();
        try{

            ResultSet result = connection.s.executeQuery("SELECT * FROM Customer");
            while(result.next()) {
                String id=result.getString("customer_id");
                String Name=result.getString("name");
                String Data=result.getString("Date");
                String Gender=result.getString("gender");
                String Marital=result.getString("address");
                String Address=result.getString("marital");
                String City=result.getString("city");
                String Pin=result.getString("pin");
                String State=result.getString("state");
                Customer customer= new Customer(Name,id,Data,Gender,Marital,Address,City,Pin,State);
                customers.add(customer);
            }
           // connection.s.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return customers;
    }
    public void create(Customer customer){
        try{

            String query = "INSERT INTO Customer (customer_id, name, Date, gender, marital, address, city, pin, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.c.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(customer.getId()));
            preparedStmt.setString(2, customer.getName());
            preparedStmt.setString(3, (customer.getData()));
            preparedStmt.setString(4, customer.getGender());
            preparedStmt.setString(5, customer.getMarital());
            preparedStmt.setString(6, customer.getAddress());
            preparedStmt.setString(7, customer.getCity());
            preparedStmt.setString(8, customer.getPin());
            preparedStmt.setString(9, customer.getState());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void update(Customer newCustomer){
        try{
            String query = "UPDATE Customer SET customer_id = ?, name = ?, Date = ?, gender = ?, marital = ?, address = ?, city = ?, pin = ?, state = ? WHERE customer_id = ?";
            PreparedStatement preparedStmt = connection.c.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(newCustomer.getId()));
            preparedStmt.setString(2, newCustomer.getName());
            preparedStmt.setString(3, (newCustomer.getData()));
            preparedStmt.setString(4, newCustomer.getGender());
            preparedStmt.setString(5, newCustomer.getMarital());
            preparedStmt.setString(6, newCustomer.getAddress());
            preparedStmt.setString(7, newCustomer.getCity());
            preparedStmt.setString(8, newCustomer.getPin());
            preparedStmt.setString(9, newCustomer.getState());
            preparedStmt.setInt(10, Integer.parseInt(newCustomer.getId()));
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void delete(Customer customer){
        try{
            String query = "DELETE FROM Customer WHERE customer_id = ?";
            PreparedStatement preparedStmt = connection.c.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(customer.getId()));
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
