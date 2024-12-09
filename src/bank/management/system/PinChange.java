package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class PinChange extends JFrame implements ActionListener{
   JButton back,change;
   JPasswordField repin,pin;
    String pinnumber;
   PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setSize(1000,1000);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,20));
        text.setBounds(200,300,200,30);
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(160,350,200,30);
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setBounds(320,350,200,30);
        pin.setFont(new Font("System",Font.BOLD,16));

        image.add(pin);
       
        JLabel repintext=new JLabel("RE-Enter New PIN");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(160,400,200,30);
        image.add(repintext);
        
         
         repin=new JPasswordField();
        repin.setBounds(320,400,200,30);
        repin.setFont(new Font("System",Font.BOLD,16));
        image.add(repin);
       
        
        change=new JButton("CHANGE");
        change.setBounds(400,490,120,30);
        change.setFont(new Font("System",Font.BOLD,16));
        image.add(change);
        change.addActionListener(this);

       
         back=new JButton("BACK");
        back.setBounds(400,520,120,30);
        back.setFont(new Font("System",Font.BOLD,16));
        image.add(back);
        back.addActionListener(this);
        
        
   }
   public void actionPerformed(ActionEvent ae){
      try{
        if(ae.getSource()== change){
             
          String npin=pin.getText();
          String rpin=pin.getText();

           if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered Pin does not match");
                return;
            }
           
            if(npin.equals(" ")){
                JOptionPane.showMessageDialog(null,"Please enterd new pin");
               return;
            }
            if(rpin.equals(" ")){
                 JOptionPane.showMessageDialog(null,"Please re-enterd new pin");
              return;
            }
            
           //else{ 
            Connection c=Conn.Conn();
        String qry="update login set pinNo=? where pinNo=?";
          PreparedStatement ps1=c.prepareStatement(qry);
          ps1.setString(1,rpin);
          ps1.setString(2,pinnumber);

         PreparedStatement ps2=c.prepareStatement("update signupthree set pinNo=? where pinNo=?");
            ps2.setString(1,rpin);
           ps2.setString(2,pinnumber);

         PreparedStatement ps3=c.prepareStatement("update bank set pin =? where pin=?");
          ps3.setString(1,rpin);
          ps3.setString(2,pinnumber);

         int a = ps1.executeUpdate();
         int b = ps2.executeUpdate();
         int d = ps3.executeUpdate();
      
            if(a>=1&&b>=1&&d>=1){
            JOptionPane.showMessageDialog(null,"pin change Succussfully");
               dispose();
               new Transactions(rpin).setVisible(true);
            } 
            else
               JOptionPane.showMessageDialog(null,"Some error");

            
    }
    else if(ae.getSource()==back){
         dispose();
         new Transactions(pinnumber).setVisible(true);
        }
   }catch(Exception e){
          System.out.println(e);
      }
    
 }
    public static void main(String args[]){
        new PinChange(" ");
    }
}