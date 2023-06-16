package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String name;
    private String id;
    private String data;
    private String gender;
    private String marital;
    private String address;
    private String city;
    private String pin;
    private String state;
    private ArrayList<Account> accounts=new ArrayList<>();

    public Customer(String name, String idd, String data, String gender, String marital, String address, String city, String pin, String state) {
        this.name = name;
        id = idd;
        this.data = data;
        this.gender = gender;
        this.marital = marital;
        this.address = address;
        this.city = city;
        this.pin = pin;
        this.state = state;
        //accounts = new ArrayList<Account>();
    }
    public Customer(){}

    public String getName() {
        return name;
    }

    public int getId() {
        return Integer.parseInt(id);
    }

    public String getData() {
        return data;
    }

    public String getGender() {
        return gender;
    }

    public String getMarital() {
        return marital;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPin() {
        return pin;
    }

    public String getState() {
        return state;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public Account getAccountById(int id) {

        for(int i = 0; i< accounts.size(); i++)
        {
            if(accounts.get(i).getAccountNumber()==id)
                return accounts.get(i);
        }
        return null;
    }
//    public void  addAccount(int id, String type)
//    {
//        Account cont= new Account(id,type);
//        accounts.add(cont);
//
//    }
    public Customer readClient() {
        Scanner cin = new Scanner(System.in);
        System.out.println("Insert data for client:");
        System.out.print("Name");
        this.name = cin.nextLine();
        System.out.print("ID:");
        this.id = cin.nextLine();
        LocalDate date = LocalDate.now();
        this.data = date.toString();
        System.out.print("Gender:");
        this.gender = cin.nextLine();
        System.out.print("Marital:");
        this.marital = cin.nextLine();
        System.out.print("Address::");
        this.address = cin.nextLine();
        System.out.print("City:");
        this.city = cin.nextLine();
        System.out.print("PIN:");
        this.pin = cin.nextLine();
        System.out.print("State:");
        this.state = cin.nextLine();
        return this;
    }

        @Override
    public String toString() {
        ArrayList<Account> conturi= getAccounts();
        if(conturi==null)
            return "No accounts created yet\n";
        String output="";
        for(int i=0;i<conturi.size();i++)
        {
            output+=conturi.get(i).getAccountNumber()+", ";
        }
        if(output!="")
        {
            output = output.substring(0, output.length() - 2);
        }

        return "Customer{" +
                "Name='" + name + '\'' +
                ", ID='" + id + '\'' +
                ", Data='" + data + '\'' +
                ", Gender='" + gender + '\'' +
                ", Marital='" + marital + '\'' +
                ", Address='" + address + '\'' +
                ", City='" + city + '\'' +
                ", Pin='" + pin + '\'' +
                ", State='" + state + '\'' +
                ", Accounts=" + output +
                '}';
    }
    public String displayAccounts()
    {
        ArrayList<Account> conturi= getAccounts();
        String output="";
        for(int i=0;i<conturi.size();i++)
        {
            output+="Contul nr. "+i+" este urmatorul:\n";
            output+="-------------------------------\n";
            output+=conturi.get(i).toString();
            output+="-------------------------------\n";
        }
        return output;
    }

    public void addAccount(Account account)
    {
        accounts.add(account);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void depositMoney(int idCont,int amount)
    {
        for (Account account: accounts)
        {
            if(account.getAccountNumber()==idCont)
            {
                account.getBankCard().depositMoney(1000);
                System.out.println("You deposited "+amount+" in your Bank Account\n");
            }
        }

    }


    public void withdrawlMoney(int idCont,int amount)
    {
        for (Account account: accounts)
        {
            if(account.getAccountNumber()==idCont)
            {
                account.getBankCard().withdrawlMoney(900);
                System.out.println("You deposited "+amount+" in your Bank Account\n");
            }
        }

    }
}
