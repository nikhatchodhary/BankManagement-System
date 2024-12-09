
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement  extends JFrame {
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
       JLabel card=new JLabel();
       card.setBounds(20,80,300,20);
       add(card);
        
       JLabel balance=new JLabel();
       balance.setBounds(20,400,300,20);
       add(balance);
        
        
        
        try{
            
            Connection c= Conn.Conn();
            PreparedStatement ps=c.prepareStatement("select * from login where pinNo='"+pinnumber+"'");
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
               card.setText("Card Number:" + rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardnumber").substring(12));        }
      }catch (Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        
        try{
            int bal=0;
           Connection c=Conn.Conn();
            PreparedStatement ps2=c.prepareStatement("select * from bank where pin='"+pinnumber+"'");
            ResultSet rs2=ps2.executeQuery();
            while(rs2.next()){
                mini.setText(mini.getText()+"<html>"+ rs2.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs2.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs2.getString("amount")+"<br><br><html>");
             if( rs2.getString("type").equals("Deposit"))
                    bal += Integer.parseInt(rs2.getString("amount"));
                else
                    bal -= Integer.parseInt(rs2.getString("amount"));
             
                balance.setText("Your current account is Rs "+bal);
          
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
     new MiniStatement(" ");
    }
    
}
