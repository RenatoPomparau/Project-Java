package View;

import Model.Cards.Card;
import Model.DatabaseConnection.CardDB;
import Model.DatabaseConnection.TransactionDB;
import Model.Transaction;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    int cardNumber;
    Deposit(String pin,int cardNumber){
        this.pin = pin;
        this.cardNumber=cardNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons_UI/atm (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 900);
        add(l3);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190,350,400,35);
        l3.add(l1);

        t1.setBounds(190,420,320,25);
        l3.add(t1);

        b1.setBounds(190,470,150,35);
        l3.add(b1);

        b2.setBounds(360,470,150,35);
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
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    Transaction tranz=new Transaction(Integer.parseInt(amount),"Deposit");
                    CardDB cdb=new CardDB();
                    Card card=cdb.readCard(cardNumber);
                    TransactionDB tdb=new TransactionDB();
                    tdb.create(card,tranz);

                    JOptionPane.showMessageDialog(null, amount+" $ Deposited Successfully");
                    setVisible(false);
                    new Transactions(cardNumber, pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(cardNumber, pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Deposit("",0).setVisible(true);
    }
}
