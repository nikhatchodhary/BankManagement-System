
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

 
public class Signupthree extends JFrame implements ActionListener{
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    JRadioButton r1,r2,r3,r4;
    String random;
    Signupthree(String random){
        this.random=random;
        setSize(800,800);
        setLocation(450,0);
        setVisible(true);
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Ralway",Font.BOLD,28));
        l1.setBounds(200,10,400,50);
        add(l1);
        getContentPane().setBackground(Color.WHITE);

        
           
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Ralway",Font.BOLD,25));
        type.setBounds(80,120,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Ralway",Font.BOLD,15));
        r1.setBounds(100,180,200,30);
        add(r1);
        r1.setBackground(Color.white);
        
       r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Ralway",Font.BOLD,15));
        r2.setBounds(100,220,200,30);
        add(r2);
        r2.setBackground(Color.white);
        
        
       r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Ralway",Font.BOLD,15));
        r3.setBounds(350,170,250,30);
        add(r3);
        r3.setBackground(Color.white);
        
        r4=new JRadioButton("Recuring Deposit Account");
        r4.setFont(new Font("Ralway",Font.BOLD,15));
        r4.setBounds(350,220,300,30);
        add(r4);
        r4.setBackground(Color.white);
        
        ButtonGroup atype=new ButtonGroup();
        atype.add(r4);
        atype.add(r3);
        atype.add(r2);
        atype.add(r1);
       
        JLabel card =new JLabel("Card Number");
        card.setFont(new Font("Railway",Font.BOLD,25));
        card.setBounds(80,270,200,30);
        add(card);
        
        JLabel number =new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Railway",Font.BOLD,20));
        number.setBounds(350,270,300,30);
        add(number);
        
        JLabel carddetail =new JLabel("your 16 digit card Number");
        carddetail.setFont(new Font("Railway",Font.BOLD,15));
        carddetail.setBounds(80,290,200,30);
        add(carddetail);
        
        JLabel pin =new JLabel("PIN");
        pin.setFont(new Font("Railway",Font.BOLD,25));
        pin.setBounds(80,350,100,30);
        add(pin);
        
        JLabel num =new JLabel("XXXX");
        num.setFont(new Font("Railway",Font.BOLD,25));
        num.setBounds(350,350,100,30);
        add(num);
        
        JLabel pindetail =new JLabel("Your 4 digit Password");
        pindetail.setFont(new Font("Railway",Font.BOLD,15));
        pindetail.setBounds(80,370,200,30);
        add(pindetail);
        
        JLabel service =new JLabel("Service Required");
        service.setFont(new Font("Railway",Font.BOLD,25));
        service.setBounds(80,440,250,30);
        add(service);
        
        c1 =new JCheckBox("ATM CARD ");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Railway",Font.BOLD,15));
        c1.setBounds(100,490,200,30);
        add(c1);
        
        c2 =new JCheckBox("Internet Banking");
        c2.setFont(new Font("Railway",Font.BOLD,15));
        c2.setBounds(300,490,200,30);
        c2.setBackground(Color.white);
        add(c2);
        
        c3 =new JCheckBox("Mobile Baking");
        c3.setFont(new Font("Railway",Font.BOLD,15));
        c3.setBounds(100,530,200,30);
        c3.setBackground(Color.white);
        add(c3);
        
        c4 =new JCheckBox("ChequeBook");
        c4.setFont(new Font("Railway",Font.BOLD,15));
        c4.setBounds(300,530,200,30);
        c4.setBackground(Color.white);
        add(c4);
        

        c5 =new JCheckBox("Email & SMS Alerts");
        c5.setFont(new Font("Railway",Font.BOLD,15));
        c5.setBounds(300,570,300,30);
        c5.setBackground(Color.white);
        add(c5);
        
                

        c6 =new JCheckBox("E-Statement");
        c6.setFont(new Font("Railway",Font.BOLD,15));
        c6.setBounds(100,570,200,30);
        c6.setBackground(Color.white);
        add(c6);
        
        c7 =new JCheckBox("I hereby declares that the above enterned details are correct to the best of my knowledge");
        c7.setFont(new Font("Railway",Font.BOLD,10));
        c7.setBounds(100,620,600,30);
        c7.setBackground(Color.white);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBounds(150,660,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        add(submit);
        submit.addActionListener(this);
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(450,660,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);

        

    }
    
    public void actionPerformed( ActionEvent ae){
        if (ae.getSource()==submit) {
            String accountType=" ";
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Current Account";
            }else if(r3.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r4.isSelected()){
                accountType="Recuring Deposit Account";
            }
            Random r=new Random();
            int a=r.nextInt(9);
            int b=r.nextInt(9);
            int o=r.nextInt(9);
            int d=r.nextInt(9);
            int e=r.nextInt(9);
            int f=r.nextInt(9);
            int g=r.nextInt(9);
            int h=r.nextInt(9);

            String cardNo ="50409360"+a+""+b+""+o+""+d+""+e+""+f+""+g+""+h;
            Random r2=new Random();
            int p=r2.nextInt(9);
            int q=r2.nextInt(9);
            int t=r2.nextInt(9);
            int s=r2.nextInt(9);
            String pinNo=p+""+q+""+t+""+s;
            
            String service="";
            if(c1.isSelected())
                service=service+"ATM Card";
             if(c2.isSelected())
                service=service+" Internet Banking";
            if(c3.isSelected())
                service=service+" Mobile Banking";
             if(c4.isSelected())
                service=service+" Cheque Book";
             if(c5.isSelected())
                service=service+" EMAIL & SMS Alerts";
             if(c6.isSelected())
            service=service+"E-Statements";
         
            
                try{
                    Connection c=Conn.Conn();
                    PreparedStatement ps=c.prepareStatement("insert into signupthree values(?,?,?,?,?)");
                    
                    ps.setString(1, random);
                    ps.setString(2, accountType);
                    ps.setString(3, cardNo);
                    ps.setString(4, pinNo);
                    ps.setString(5, service);
                    int p2=ps.executeUpdate();
                    
                    PreparedStatement ps2=c.prepareStatement("insert into login values(?,?,?)");
                    ps2.setString(1, random);
                    ps2.setString(2, cardNo);
                    ps2.setString(3, pinNo);

                    int p3=ps2.executeUpdate();

                    
                    if(accountType.equals(""))
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                    else if(p3==1){
                     JOptionPane.showMessageDialog(null,"Card Nunber: "+ cardNo+ "\n Pin: "+pinNo);
                      setVisible(false);
                      new Deposit(pinNo).setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Some error");
                } catch(Exception ex){
                    System.out.println(ex);
            
                    }   
            }   
                
  
        else{
          dispose();
          new Login().setVisible(true);
        
        }   
   
    }
    public static void main(String args[]){
        new Signupthree("");
    }
    
    
}
