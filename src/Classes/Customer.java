package Classes;

import java.util.ArrayList;

public class Customer {
    private String Name;
    private String id;
    private String Data;
    private String Gender;
    private String Marital;
    private String Address;
    private String City;
    private String Pin;
    private String State;
    private ArrayList<Account> Accounts;

    public Customer(String name, String idd, String data, String gender, String marital, String address, String city, String pin, String state) {
        Name = name;
        id = idd;
        Data = data;
        Gender = gender;
        Marital = marital;
        Address = address;
        City = city;
        Pin = pin;
        State = state;
        Accounts = new ArrayList<Account>();
    }
    public Customer(){}

    public String getName() {
        return Name;
    }

    public String getId() {
        return id;
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
        Account cont= new Account(id,type);
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
        if(output!="")
        {
            output = output.substring(0, output.length() - 2);
        }

        return "Customer{" +
                "Name='" + Name + '\'' +
                ", ID='" + id + '\'' +
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
        Accounts.add(account);
    }
    public void setName(String name) {
        Name = name;
    }

    public void setId(String id) {
        this.id = id;
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

    public void depositMoney(int idCont,int amount)
    {
        for (Account account:Accounts)
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
        for (Account account:Accounts)
        {
            if(account.getAccountNumber()==idCont)
            {
                account.getBankCard().withdrawlMoney(900);
                System.out.println("You deposited "+amount+" in your Bank Account\n");
            }
        }

    }
}
