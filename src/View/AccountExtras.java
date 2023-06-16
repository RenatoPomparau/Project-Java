package View;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AccountExtras extends JFrame implements ActionListener{

    JButton b1, b2;
    JLabel l1;
    int cardNumber;
    AccountExtras(String pin,int cardNumber){
        super("Transactions");
        this.cardNumber=cardNumber;
        getContentPane().setBackground((new Color(250,250,210)));
        setSize(400,600);
        setLocation(20,20);

        l1 = new JLabel();
        add(l1);

        JLabel l2 = new JLabel("Bank transaction display");
        l2.setBounds(20, 20, 300, 20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from card where card_number = '"+cardNumber+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}

        try{
            double balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM transaction where card_id = '"+cardNumber+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("transaction_date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transaction_type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("transaction_type").equals("Deposit")){
                    balance += Double.parseDouble(rs.getString("amount"));
                }else{
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is : "+balance+"$");
        }catch(Exception e){
            e.printStackTrace();
        }



        setLayout(null);
        l1.setBounds(20, 140, 400, 200);
        b1 = new JButton("Exit");
        add(b1);
        b1.addActionListener(this);
//        JTextArea textArea = new JTextArea(20, 20);
//        JScrollPane scrollableTextArea = new JScrollPane(textArea);
//
//        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        l1.add(scrollableTextArea);

        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args){
        new AccountExtras("",0).setVisible(true);
    }

}