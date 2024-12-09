
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class Withdrawl extends JFrame implements ActionListener{
    JButton back,withdrawl;
    String pinnumber;
    JTextField amount;
Withdrawl(String pinnumber){
    this.pinnumber=pinnumber;
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpeg"));
    Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
    
    JLabel text=new JLabel("Enter the amount you want to withdrawl");
    text.setBounds(180,300,300,30);
    text.setFont(new Font("system",Font.BOLD,16));
    text.setForeground(Color.white);
    image.add(text);
    
    amount=new JTextField();
    amount.setBounds(180,350,300,30);
    amount.setFont(new Font("Railway",Font.BOLD,22));
    image.add(amount);
    
    withdrawl = new JButton("Withdrawl");
    withdrawl.setBounds(400,460,100,30);
    image.add(withdrawl);
    withdrawl.addActionListener(this);
    
    back=new JButton("Back");
    back.setBounds(400,500,100,30);
    image.add(back);
    back.addActionListener(this);

}
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==withdrawl){
            Date date=new Date();
            if(amount.getText().equals(" "))
              JOptionPane.showMessageDialog(null,"please enter the amount you want to deposit"); 
            else{
                try{
                    Connection c=Conn.Conn();
                    PreparedStatement ps=c.prepareStatement("insert into bank values(?,?,?,?)");
                    ps.setString(1, pinnumber);
                    ps.setString(2,date.toString());
                    ps.setString(3, "withdrawl");
                    ps.setString(4, amount.getText());
                    
                    int a=ps.executeUpdate();
                    if(a==1)
                        
                      JOptionPane.showMessageDialog(null, "Rs "+amount.getText()+"withdrawl Sucussfully");
                        dispose();
                        new Transactions(pinnumber).setVisible(true);
                        
                }catch(Exception ae){
                    System.out.println(ae);
                }
            }
                
            
            
        }else if(e.getSource()==back){
            new Transactions(pinnumber).setVisible(true);
        }
            
            
            
    }
    
    public static void main(String[] args) {
        new Withdrawl("");
        
    }
    
}

