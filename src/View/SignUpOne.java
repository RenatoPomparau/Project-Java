package View;
import javax.swing.*;
import java.awt.*;

import Model.Customer;
import Model.DatabaseConnection.CustomerDB;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.Random;

public class SignUpOne extends JFrame implements ActionListener {

    JButton next;
    JRadioButton male, female,married, unmarried;
    JDateChooser dateChooser;
    JTextField stateTextField,nameTextField, fnameTextField,dobTextField, emailTextField, addressTextField, cityTextField,dateTextField, pincodeTextField;
    SignUpOne(){

        setLayout(null);


        JLabel titlu = new JLabel("Application form");
        titlu.setFont(new Font("Raleway",Font.BOLD,30));
        titlu.setBounds(125,20,600,40);
        titlu.setHorizontalAlignment(JTextField.CENTER);
        System.out.println(titlu.getWidth());
        add(titlu);

        JLabel subtitlu = new JLabel("Personal details");
        subtitlu.setFont(new Font("Raleway",Font.BOLD,22));
        subtitlu.setBounds(250,80,350,30);
        subtitlu.setHorizontalAlignment(JTextField.CENTER);
        add(subtitlu);
        getContentPane().setBackground((new Color(250,250,210)));
        setSize(850,800);
        setLocation(350,10);

        JLabel name1 = new JLabel("Name");
        name1.setFont(new Font("Raleway",Font.BOLD,20));
        name1.setBounds(50,190,200,30);
        name1.setHorizontalAlignment(JTextField.CENTER);
        add(name1);
        nameTextField= new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(300,190,400,30);
        nameTextField.setHorizontalAlignment(JTextField.CENTER);
        add(nameTextField);

        JLabel name = new JLabel("Father's name");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(50,240,200,30);
        name.setHorizontalAlignment(JTextField.CENTER);
        add(name);
        fnameTextField= new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        fnameTextField.setBounds(300,240,400,30);
        fnameTextField.setHorizontalAlignment(JTextField.CENTER);
        add(fnameTextField);

        JLabel name2 = new JLabel("Date Of Birth");
        name2.setFont(new Font("Raleway",Font.BOLD,20));
        name2.setBounds(50,290,200,30);
        name2.setHorizontalAlignment(JTextField.CENTER);
        add(name2);
        dateChooser= new JDateChooser();
        dateChooser.setBounds(300,290,400,30);
        dateChooser.setBackground(new Color(250,250,210));
        add(dateChooser);


        JLabel name3 = new JLabel("Gender");
        name3.setFont(new Font("Raleway",Font.BOLD,20));
        name3.setBounds(50,340,200,30);
        name3.setHorizontalAlignment(JTextField.CENTER);
        add(name3);
        male = new JRadioButton("Male");
        male.setBounds(300,340,60,30);
        male.setBackground(new Color(250,250,210));
        add(male);
        female = new JRadioButton("female");
        female.setBounds(500,340,100,30);
        female.setBackground(new Color(250,250,210));
        add(female);

        JLabel name4 = new JLabel("Marital Status");
        name4.setFont(new Font("Raleway",Font.BOLD,20));
        name4.setBounds(50,390,200,30);
        name4.setHorizontalAlignment(JTextField.CENTER);
        add(name4);
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(new Color(250,250,210));
        add(married);
         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(500,390,100,30);
        unmarried.setBackground(new Color(250,250,210));
        add(unmarried);

        JLabel name5 = new JLabel("Adress");
        name5.setFont(new Font("Raleway",Font.BOLD,20));
        name5.setBounds(50,440,200,30);
        name5.setHorizontalAlignment(JTextField.CENTER);
        add(name5);
        addressTextField= new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setHorizontalAlignment(JTextField.CENTER);
        add(addressTextField);


        JLabel name6 = new JLabel("City");
        name6.setFont(new Font("Raleway",Font.BOLD,20));
        name6.setBounds(50,490,200,30);
        name6.setHorizontalAlignment(JTextField.CENTER);
        add(name6);
        cityTextField= new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setHorizontalAlignment(JTextField.CENTER);
        add(cityTextField);


        JLabel name7 = new JLabel("State");
        name7.setFont(new Font("Raleway",Font.BOLD,20));
        name7.setBounds(50,540,200,30);
        name7.setHorizontalAlignment(JTextField.CENTER);
        add(name7);
        stateTextField= new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setHorizontalAlignment(JTextField.CENTER);
        add(stateTextField);


        JLabel name8 = new JLabel("PIN Code");
        name8.setFont(new Font("Raleway",Font.BOLD,20));
        name8.setBounds(50,590,200,30);
        name8.setHorizontalAlignment(JTextField.CENTER);
        add(name8);
         pincodeTextField= new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pincodeTextField.setBounds(300,590,400,30);
        pincodeTextField.setHorizontalAlignment(JTextField.CENTER);
        add(pincodeTextField);

        JLabel name9 = new JLabel("Email");
        name9.setFont(new Font("Raleway",Font.BOLD,20));
        name9.setBounds(50,640,200,30);
        name9.setHorizontalAlignment(JTextField.CENTER);
        add(name9);
        emailTextField= new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(300,640,400,30);
        emailTextField.setHorizontalAlignment(JTextField.CENTER);
        add(emailTextField);


        next= new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,690,80,30);
        next.addActionListener(this);
        add(next);

        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae)
    {
        String name = nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob= ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()) {
            gender="male";
        }
       else gender="female";
       String email=emailTextField.getText();
       String marital= null;
        if(married.isSelected()) {
            marital="Married";
        }
        else marital="Unmarried";
        String address=addressTextField.getText();
        String city= cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pincodeTextField.getText();
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
            Conn c = new Conn();
            Customer client_sigUpOne= new Customer();
            Random random = new Random();
            client_sigUpOne.setId(String.valueOf(random.nextInt(90000) + 10000));
            client_sigUpOne.setName(name);
            client_sigUpOne.setData(dob);
            client_sigUpOne.setGender(gender);
            client_sigUpOne.setAddress(address);
            client_sigUpOne.setCity(city);
            client_sigUpOne.setPin(pin);
            client_sigUpOne.setState(state);
            System.out.println(client_sigUpOne);
            CustomerDB baza=new CustomerDB();
            baza.create(client_sigUpOne);
            System.out.println(client_sigUpOne);
            String query= "insert into signup values('" +name+ "', '"+ fname+ "', '"+dob+"', '"+gender+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
            System.out.println(query);
            //query= "insert into customer values('" +name+ "', '"+ fname+ "', '"+dob+"', '"+gender+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";

                c.s.executeUpdate(query);
        setVisible(false);
        new SignUpTwo(client_sigUpOne).setVisible(true);
            }
        }
            catch (Exception e){System.out.println(e);}
        }



    public static void main(String[] args) {

         new SignUpOne();
    }
}
