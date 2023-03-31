package Classes;

import java.util.ArrayList;

public class Customer {
    private String Name;
    private String Father_name;
    private String Data;
    private String Gender;
    private String Marital;
    private String Address;
    private String City;
    private String Pin;
    private String State;
    private ArrayList<Account> Accounts;

    public Customer(String name, String father_name, String data, String gender, String marital, String address, String city, String pin, String state) {
        Name = name;
        Father_name = father_name;
        Data = data;
        Gender = gender;
        Marital = marital;
        Address = address;
        City = city;
        Pin = pin;
        State = state;
        Accounts = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public String getFather_name() {
        return Father_name;
    }

    public String getData() {
        return Data;
    }

    public String getGender() {
        return Gender;
    }

    public String getMarital() {
        return Marital;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getPin() {
        return Pin;
    }

    public String getState() {
        return State;
    }

    public ArrayList<Account> getAccounts() {
        return Accounts;
    }
    public Account getAccountById(int id) {

        for(int i=0;i<Accounts.size();i++)
        {
            if(Accounts.get(i).getAccountNumber()==id)
                return Accounts.get(i);
        }
        return null;
    }
    public void  addAccount(int id, String type)
    {
        Account cont= new Account(id,0,type);
        Accounts.add(cont);

    }

    @Override
    public String toString() {
        ArrayList<Account> conturi= getAccounts();
        String output="";
        for(int i=0;i<conturi.size();i++)
        {
            output+=conturi.get(i).getAccountNumber()+", ";
        }
        output = output.substring(0, output.length() - 2);
        return "Customer{" +
                "Name='" + Name + '\'' +
                ", Father_name='" + Father_name + '\'' +
                ", Data='" + Data + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Marital='" + Marital + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", Pin='" + Pin + '\'' +
                ", State='" + State + '\'' +
                ", Accounts=" + output +
                '}';
    }

    public void setName(String name) {
        Name = name;
    }

    public void setFather_name(String father_name) {
        Father_name = father_name;
    }

    public void setData(String data) {
        Data = data;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setMarital(String marital) {
        Marital = marital;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    public void setState(String state) {
        State = state;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        Accounts = accounts;
    }

    public void depositMoney(int idCont)
    {
        for (Account account:Accounts)
        {
            if(account.getAccountNumber()==idCont)
            {
                Transaction transaction=new Transaction(43228638,1000,"Deposit");
                account.addTransaction(transaction);
                System.out.println(account.toString());
            }
        }



    }
}
