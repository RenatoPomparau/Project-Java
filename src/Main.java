import Model.Service.ServiceClass;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws SQLException {
        Scanner cin=new Scanner(System.in);

        ServiceClass Service = new ServiceClass();
        int caz;
        while(true)
        {
            System.out.println("1: Add a customer");
            System.out.println("2: Delete a customer");
            System.out.println("3: Update a customer");
            System.out.println("4: Add a customer");
            System.out.println("5: Add an card for an account");
            System.out.println("6: Make a transaction for a customer");
            System.out.println("7: Print all customers ");
            System.out.println("8: Print all accounts ");
            System.out.println("9: Add account ");
            System.out.print("What do you choose: ");

            caz=cin.nextInt();
            switch(caz)
            {
                case 1:
                    Service.AddCustomer(); //create a customer
                    break;
                case 2:
                    Service.DeleteCustomer(); //create a customer
                    break;
                case 3:
                    Service.UpdateCustomer(); //create a customer
                    break;
                case 4:
                    Service.PrintACustomer(); //create a customer
                    break;
                case 5:
                    Service.CreateCard(); //assign a card to a specific customer
                    break;
                case 6:
                    Service.AddTransactionToCard(); ;//create a transaction for a customer
                    break;
                case 7:
                    Service.PrintCustomers();
                    break;
                case 8:
                    Service.PrintAccounts();
                    break;


///dispaly all transaction/ all clients , all cards etc

            }
        }


}}