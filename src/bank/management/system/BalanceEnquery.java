
package bank.management.system;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquery extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    BalanceEnquery(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
     
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
      setSize(900,900);
      setLocation(300,0);
      setVisible(true);
   
      
         
           Connection c=Conn.Conn();
              int balance=0;

           try{
            PreparedStatement ps=c.prepareStatement("select * from bank where pin='"+pinnumber+"'");
            
            ResultSet rs=ps.executeQuery();
             

            while(rs.next()){
                if( rs.getString("type").equals("Deposit"))
                    balance += Integer.parseInt(rs.getString("amount"));
                else
                    balance -= Integer.parseInt(rs.getString("amount"));
            }
           }catch(Exception e){
               System.out.println(e);
           }
           JLabel text=new JLabel("Your Current Account Balance is Rs "+balance);
           text.setBounds(170,300,400,30);
           text.setFont(new Font("Railway",Font.BOLD,16));
           text.setForeground(Color.white);
           image.add(text);
      
      back=new JButton("Back");
      back.setBounds(355,520,150,30);
      image.add(back);
      back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        
    }
    public static void main(String[] args) {
        
        new BalanceEnquery(" ");
    }

    
    
}
