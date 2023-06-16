package View;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

    JPasswordField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin;
    int cardNUmber;
    PinChange(String pin, int cardNumber){
        this.pin = pin;
        this.cardNUmber=cardNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons_UI/atm (1).jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 900);
        add(l4);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        l1.setBounds(280,330,800,35);
        l4.add(l1);

        l2.setBounds(180,390,150,35);
        l4.add(l2);

        l3.setBounds(180,440,200,35);
        l4.add(l3);

        t1.setBounds(350,390,180,25);
        l4.add(t1);

        t2.setBounds(350,440,180,25);
        l4.add(t2);

        b1.setBounds(180,490,150,35);
        l4.add(b1);

        b2.setBounds(350,490,150,35);
        l4.add(b2);

        setSize(960,900);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        try{
            String npin = t1.getText();
            String rpin = t2.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }

                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signuptwo set pin = '"+rpin+"' where pin = '"+pin+"' ";
                System.out.println(rpin);
                System.out.println(pin);
                System.out.println(cardNUmber);

                String q4 = "UPDATE card SET security_code = '" + rpin + "' WHERE security_code = '" + pin + "' AND card_number = '" + cardNUmber + "'";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                c1.s.executeUpdate(q4);
                System.out.println();
                String q5 = "select acc_number from card where card_number='"+cardNUmber+"' ";
                ResultSet rs= c1.s.executeQuery(q5);

                if (rs.next()) {
                    int account_number = Integer.parseInt(rs.getString("acc_number"));
                    q4 = "update account set pin = '" + rpin + "' where account_number = '" + account_number + "' ";
                    c1.s.executeUpdate(q4);
                    String q6 = "select user_id from account where account_number='" + account_number + "' ";
                    rs = c1.s.executeQuery(q6);
                    int customer_id = 0;
                    if (rs.next()) {
                        customer_id = Integer.parseInt(rs.getString("user_id"));
                    }
                    System.out.println(customer_id);
                    q4 = "update customer set pin = '" + rpin + "' where customer_id = '" + customer_id + "' ";
                    c1.s.executeUpdate(q4);
                }
                else { System.out.println("Not found");}



                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(cardNUmber,rpin).setVisible(true);

            }else if(ae.getSource()==b2){
                new Transactions(cardNUmber, pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

        public static void main(String[] args){
        new PinChange("", 0).setVisible(true);
    }
}