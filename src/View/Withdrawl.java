package View;

import Model.Cards.Card;
import Model.DatabaseConnection.CardDB;
import Model.DatabaseConnection.TransactionDB;
import Model.Transaction;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    int cardNumber;
    Withdrawl(String pin,int cardNumber){
        this.pin = pin;
        this.cardNumber=cardNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons_UI/atm (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 900);
        add(l3);


        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null);



        l2.setBounds(190,400,400,20);
        l3.add(l2);

        t1.setBounds(190,450,330,30);
        l3.add(t1);

        b1.setBounds(190,500,150,35);
        l3.add(b1);

        b2.setBounds(370,500,150,35);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960,900);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        try{
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();

                    ResultSet rs = c1.s.executeQuery("select * from transaction where card_id = '"+cardNumber+"'");
                    double balance = 0;
                    while(rs.next()){
                        if(rs.getString("transaction_type").equals("Deposit")){
                            balance += Double.parseDouble(rs.getString("amount"));
                        }else{
                            balance -= Double.parseDouble(rs.getString("amount"));
                        }
                    }
                    if(balance < Double.parseDouble(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    Transaction tranz=new Transaction(Double.parseDouble(amount),"Withdrawl");
                    CardDB cdb=new CardDB();
                    Card card=cdb.readCard(cardNumber);
                    TransactionDB tdb=new TransactionDB();
                    tdb.create(card,tranz);

                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,  amount+"$ Debited Successfully");

                    setVisible(false);
                    new Transactions(cardNumber, pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(cardNumber, pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
        }

    }



    public static void main(String[] args){
        new Withdrawl("",0).setVisible(true);
    }
}