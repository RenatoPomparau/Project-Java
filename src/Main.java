import Classes.Account;
import Classes.Customer;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String actualDate= date.toString();
        Customer client= new Customer("Renato","Cristian", actualDate,"Male","Unmarried","Aviator Popisteanu","Bucharest","2002","Romania");
        ArrayList<Account> conturi= client.getAccounts();
        client.addAccount(21032002,"Savings Account");
        client.depositMoney(21032002);
        System.out.println(client.toString());
    }

}