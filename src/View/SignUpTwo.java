package View;

import Model.Account;
import Model.Cards.Card;
import Model.Cards.Savings;
import Model.Customer;
import Model.DatabaseConnection.AccountDB;
import Model.DatabaseConnection.CardDB;
import Model.DatabaseConnection.CustomerDB;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class SignUpTwo extends JFrame implements ActionListener {
    Customer client;

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton r1, r2, r3, r4;
    JButton submit, cancel;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;

    SignUpTwo(Customer client_signUpOne) {
        client=client_signUpOne;

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));

        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));

        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));

        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));


        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground((new Color(250,250,210)));

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground((new Color(250,250,210)));


        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(250,250,210));
        c1.setFont(new Font("Raleway", Font.BOLD, 16));

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(250,250,210));
        c2.setFont(new Font("Raleway", Font.BOLD, 16));

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(250,250,210));
        c3.setFont(new Font("Raleway", Font.BOLD, 16));

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(new Color(250,250,210));
        c4.setFont(new Font("Raleway", Font.BOLD, 16));

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(250,250,210));
        c5.setFont(new Font("Raleway", Font.BOLD, 16));

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(250,250,210));
        c6.setFont(new Font("Raleway", Font.BOLD, 16));

        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.", true);
        c7.setBackground(new Color(250,250,210));
        c7.setFont(new Font("Raleway", Font.BOLD, 12));


        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(new Color(250,250,210));

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(new Color(250,250,210));

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(new Color(250,250,210));

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(new Color(250,250,210));

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);

        setLayout(null);




        l1.setBounds(280, 40, 400, 40);
        add(l1);

        l2.setBounds(100, 140, 200, 30);
        add(l2);

        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2.setBounds(350, 180, 300, 30);
        add(r2);

        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4.setBounds(350, 220, 250, 30);
        add(r4);

        l3.setBounds(100, 300, 200, 30);
        add(l3);

        l4.setBounds(330, 300, 250, 30);
        add(l4);

        l5.setBounds(100, 330, 200, 20);
        add(l5);

        l6.setBounds(330, 330, 500, 20);
        add(l6);

        l7.setBounds(100, 370, 200, 30);
        add(l7);

        l8.setBounds(330, 370, 200, 30);
        add(l8);

        l9.setBounds(100, 400, 200, 20);
        add(l9);

        l10.setBounds(100, 450, 200, 30);
        add(l10);

        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7.setBounds(100, 680, 600, 20);
        add(c7);

        submit.setBounds(250, 720, 100, 30);
        add(submit);

        cancel.setBounds(420, 720, 100, 30);
        add(cancel);


        getContentPane().setBackground((new Color(250,250,210)));

        setSize(850, 850);
        setLocation(500, 120);
        setVisible(true);

        submit.addActionListener(this);
        cancel.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== submit) {

            String atype = null;

            if (r1.isSelected()) {
                atype = "Saving Account";
            } else if (r2.isSelected()) {
                atype = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                atype = "Current Account";
            } else if (r4.isSelected()) {
                atype = "Recurring Deposit Account";
            }

            Random ran = new Random();
            long first7 = (ran.nextLong() % 90000000L) + 50409360L;
            String cardno = "" + Math.abs(first7);

            long first3 = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(first3);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card";
            }
            if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            }
            if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            }
            if (c4.isSelected()) {
                facility = facility + " EMAIL Alerts";
            }
            if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            }
            if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }
            try {
                if (atype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else {
                    Conn conn = new Conn();
                    String query = "insert into signuptwo values('" + atype + "', '" + cardno + "', '" + pin + "', '" + facility + "')";
                    String query2 = "insert into login values('" + cardno + "', '" + client.getPin() + "')";
                  //  String query3 = "insert into account values('" + atype + "', '" + cardno + "', '" + pin + "', '" + facility + "')";
                    Account cont_singUpTwo=new Account();
                    cont_singUpTwo.setAccountType(atype);
                    cont_singUpTwo.setPin(Integer.parseInt(pin));
                    cont_singUpTwo.setAccountNumber(Integer.parseInt(cardno));
                    cont_singUpTwo.setUser_id(client.getId());

                    AccountDB baza_acc=new AccountDB();
                    baza_acc.create(cont_singUpTwo,client);
                    CardDB baza_card=new CardDB();
                    if(atype.equals("Saving Account"))
                    {
                        System.out.println("Errorr");
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.YEAR, 5); // Add 5 years to the current date

                        Date exp = calendar.getTime();
                        System.out.println(exp);
                        Card savings=new Savings(Integer.parseInt(cardno),client.getName(),exp,Integer.parseInt(client.getPin()),0,10,10);
                        baza_card.create(savings,client,cont_singUpTwo);
                    }


                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    System.out.println(query);
                    System.out.println(query2);
                    JOptionPane.showMessageDialog(null, "Card number: " + cardno + "\nPin: " + client.getPin());
                    new Login().setVisible(true);
                    setVisible(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel)
        {
        setVisible(false);
        new Login().setVisible(true);
        }

    }

    public static void main(String[] args) {

        Customer client_signUpOne=new Customer();
        new SignUpTwo(client_signUpOne).setVisible(true);
    }
}
