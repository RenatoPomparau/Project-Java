package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Transactions(String pinnumber){
        this.pin = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons_UI/atm (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 900);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));


        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
     //   b3 = new JButton("FAST CASH");
     //   b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("TRANSACTIONS");
        b7 = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(235,300,700,35);
        l2.add(l1);

        b1.setBounds(170,399,150,35);
        l2.add(b1);

        b2.setBounds(390,399,150,35);
        l2.add(b2);

        b5.setBounds(170,443,150,35);
        l2.add(b5);

        b6.setBounds(390,443,150,35);
        l2.add(b6);

        b7.setBounds(170,488,150,35);
        l2.add(b7);



        b1.addActionListener(this);
        b2.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);


        setSize(960,900);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);

        }else if(ae.getSource()==b6){
            new AccountExtras(pin).setVisible(true);
        }else if(ae.getSource()==b5) {
            setVisible(false);
            new PinChange(pin).setVisible(true);

        }else if(ae.getSource()==b7){
            System.exit(0);
        }
    }

    public static void main(String[] args){

    }


}