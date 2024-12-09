
package bank.management.system;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class SignupOne extends JFrame implements ActionListener {
    
  
    JTextField nametextfield ,fnametextfield,emailtextfield,adresstextfield,citytextfield,statetextfield,pintextfield;
    JDateChooser dateChooser;
    JButton nextbutton;
    JRadioButton  male,female,other,married,unmarried;
    String random;
    JLabel name,email,fname;
    SignupOne(){
        setLayout(null);
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        Random r=new Random();
        int a=r.nextInt(9);
        int b=r.nextInt(9);
        int c=r.nextInt(9);
        int d=r.nextInt(9);
        random=  a+""+b+""+c+""+d;
        JLabel formno=new JLabel("Application Form No."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,40));
        formno.setBounds(150,40,600,40);
        add(formno);
        
        JLabel personaldetail=new JLabel("Page 1: Personal Details");
        personaldetail.setFont(new Font("Raleway",Font.BOLD,28));
        personaldetail.setBounds(200,100,400,40);
        add(personaldetail);
        
        name=new JLabel("Full Name");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,150,200,40);
        add(name);
        
         nametextfield=new JTextField();
        nametextfield.setBounds(300,150,350,30);
        nametextfield.setFont(new Font("Ralway",Font.BOLD,15));
        add(nametextfield);
        
         fname=new JLabel("Father's Name");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,200,200,40);
        add(fname);
        
        fnametextfield=new JTextField();
        fnametextfield.setBounds(300,200,350,30);
        nametextfield.setFont(new Font("Ralway",Font.BOLD,15));
        add(fnametextfield);
        
        JLabel dob=new JLabel("Date Of Birth");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,250,200,40);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,250,350,30);
        dateChooser.setFont(new Font("Osward",Font.BOLD,15));
        add(dateChooser);
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,300,100,40);
        add(gender);
        
       
        male=new JRadioButton("Male");
        male.setBounds(300,300,70,30);
        male.setBackground(Color.white);
        add(male);
        
        
        female=new JRadioButton("Female");
        female.setBounds(420,300,70,30);
        female.setBackground(Color.white);
        add(female);
        
        
        other=new JRadioButton("Other");
        other.setBounds(530,300,70,30);
        other.setBackground(Color.white);
        add(other);
                      
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel email=new JLabel("Email Adress");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,350,200,40);
        add(email);
        
        emailtextfield=new JTextField();
        emailtextfield.setBounds(300,350,350,30);
        emailtextfield.setFont(new Font("Ralway",Font.BOLD,15));
        add(emailtextfield);
        
       JLabel marital=new JLabel("Marital Status");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,400,200,40);
        add(marital);
        
         married=new JRadioButton("Married");
         married.setBounds(300,400,100,30);
         married.setBackground(Color.white); 
         add(married);
                
        unmarried=new JRadioButton("UnMarried");
         unmarried.setBounds(450,400,100,30);
         unmarried.setBackground(Color.white); 
         add(unmarried);
         
         ButtonGroup statusgrp =new ButtonGroup();
         statusgrp.add(married);
         statusgrp.add(unmarried);
                
        
       JLabel adress=new JLabel("Adress");
        adress.setFont(new Font("Raleway",Font.BOLD,22));
        adress.setBounds(100,450,100,40);
        add(adress);
        
         adresstextfield=new JTextField();
        adresstextfield.setBounds(300,450,350,30);
        adresstextfield.setFont(new Font("Ralway",Font.BOLD,15));
        add(adresstextfield);
        
        JLabel city=new JLabel("City");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,500,100,40);
        add(city);
        
        citytextfield=new JTextField();
        citytextfield.setBounds(300,500,350,30);
        citytextfield.setFont(new Font("Ralway",Font.BOLD,15));
        add(citytextfield);
        
        JLabel state=new JLabel("State");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,550,100,40);
        add(state);
        
         statetextfield=new JTextField();
        statetextfield.setBounds(300,550,350,30);
        statetextfield.setFont(new Font("Ralway",Font.BOLD,15));
        add(statetextfield);
        
         JLabel pincode=new JLabel("Pin Code");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,600,100,40);
        add(pincode);
        
       pintextfield=new JTextField();
        pintextfield.setBounds(300,600,350,30);
        pintextfield.setFont(new Font("Ralway",Font.BOLD,15));
        add(pintextfield);
        
        JButton nextbutton=new JButton("Next");
        nextbutton.setBounds(550,650,100,30);
        nextbutton.setForeground(Color.white);
        nextbutton.setBackground(Color.black);
        add(nextbutton);
       nextbutton.addActionListener( this);
      
     
      
    }
    public void actionPerformed(ActionEvent e){
        try{
           Connection c=Conn.Conn();
           PreparedStatement ps=c.prepareStatement("insert into signup values(?,?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1,random);
           ps.setString(2,nametextfield.getText());
           ps.setString(3,fnametextfield.getText());
           ps.setString(4,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
           String gender=null;
           if (male.isSelected()){
               gender="Male";
           }else if(female.isSelected()){
               gender="female";
           }else
               gender="Other";
           ps.setString(5,gender);
           ps.setString(6,emailtextfield.getText());
           String marital=null;
           if(married.isSelected()){
               marital="Married";
           }else
               marital="Unmarried";
           ps.setString(7,marital);
           ps.setString(8,adresstextfield.getText());
           ps.setString(9,citytextfield.getText());
           ps.setString(10,pintextfield.getText());
           ps.setString(11,statetextfield.getText());
          int a=ps.executeUpdate();
            if(nametextfield.getText().equals(""))
                 JOptionPane.showMessageDialog(null,"Name is required");
               
            else if(fnametextfield.getText().equals(""))
                 JOptionPane.showMessageDialog(null," fathr'sname is required");
               
            else if(emailtextfield.getText().equals(""))
                 JOptionPane.showMessageDialog(null,"Email id is required");
               
            else if(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals(""))
                 JOptionPane.showMessageDialog(null,"DOB is required");
            
            else  if(adresstextfield.getText().equals(""))
                 JOptionPane.showMessageDialog(null,"adress is required");
            
           else if(citytextfield.getText().equals(""))
                 JOptionPane.showMessageDialog(null,"City  is required");
            
           else if(statetextfield.getText().equals(""))
                 JOptionPane.showMessageDialog(null,"state  is required");
               
           else if(pintextfield.getText().equals(""))
                 JOptionPane.showMessageDialog(null,"pin is required");
            
           else if(marital.equals(""))
                 JOptionPane.showMessageDialog(null,"marital status is required");
            
           else if(gender.equals(""))
                 JOptionPane.showMessageDialog(null,"gender is required");
            
            else {
               JOptionPane.showMessageDialog(null,"Succusfully Submited");
               dispose();
               new Signup2(random).setVisible(true);
                           

           }
          // else 
             //  JOptionPane.showMessageDialog(null,"Some error");
       }
        catch(Exception ex){
            System.out.println(ex);
            
        }
    }
    
    public static void main(String[] args) {
      new SignupOne(); 
    }
    
}
