package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton login, up,clear;
    JTextField textCard,textCard2;
    Login(){
        setTitle("ATM");

        setLayout(null);



        ImageIcon logo= new ImageIcon(ClassLoader.getSystemResource("Icons_UI/logo2.png"));
        Image i2=logo.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel title=new JLabel("Welcome to ATM");
        title.setFont(new Font("Osward",Font.BOLD,30));
        title.setBounds(200,40,400,100);
        add(title);

        JLabel card=new JLabel("Card number: ");
        card.setFont(new Font("Osward",Font.BOLD,20));
        card.setBounds(120,200,150,40);
        add(card);
        textCard= new JTextField();
        textCard.setBounds(300,200,250,30);
        add(textCard);


        JLabel pin=new JLabel("PIN: ");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(120,250,250,30);
        add(pin);
         textCard2= new JTextField();
        textCard2.setBounds(300,250,250,30);
        add(textCard2);

         login = new JButton("SIGN IN");
        login.setBounds(300,300,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

         clear = new JButton("CLEAR");
        clear.setBounds(430,300,120,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

         up = new JButton("SIGN UP");
        up.setBounds(300,350,250,30);
        up.setBackground(Color.black);
        up.setForeground(Color.white);
        up.addActionListener(this);
        add(up);



        getContentPane().setBackground((new Color(250,250,210)));

        //Size of the interface
        setSize(700,500);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==clear){
        textCard.setText("");
        textCard2.setText("");
    }else if (e.getSource()==up)
    {

    }
    else if (e.getSource()==login)
    {

    }
    }
    public static void main(String[] args) {
        new Login();
    }


}
