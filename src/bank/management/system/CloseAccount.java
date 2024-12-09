
package bank.management.system;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class CloseAccount extends JFrame implements ActionListener{
   static JTextField pinText;
    JLabel pin;
    JButton delete,cancel;
    String pinnumber;
     public static boolean checkAccontNo(String pinNo){
       boolean n=false;
            try{
                
                Connection c=Conn.Conn();
                String qry="select * from login where pinNo=?";
		PreparedStatement ps =c.prepareStatement(qry);
			ps.setString(1,pinNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
                            n=true;
                        }
            }catch(Exception e){
                System.out.println(e);
            }  
            return n;
     }
    
    CloseAccount(String pinnumber){
      this.pinnumber=pinnumber;
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
    setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpeg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    pin=new JLabel("Detele your account with pin no is");
   pin.setBounds(160,310,300,30);
    pin.setForeground(Color.WHITE);
    pin.setFont(new Font("Railway",Font.BOLD,16));
    image.add(pin);
 
    pinText=new JTextField();
    pinText.setBounds(160,350,100,30);
    pinText.setFont(new Font("Railway",Font.BOLD,16));
    pinText.setText(pinnumber);
    pinText.setEditable(false);
    image.add(pinText);
  
    cancel=new JButton("Cancel");
    cancel.setBounds(150,520,100,30);
    cancel.setFont(new Font("Railway",Font.BOLD,16));
    image.add(cancel);
    cancel.addActionListener(this);
     
    
    delete=new JButton("delete");
    delete.setBounds(420,520,100,30);
    delete.setFont(new Font("Railway",Font.BOLD,16));
    delete.addActionListener(this);
    image.add(delete);
    }    
      public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            dispose();
            new Transactions(pinnumber);
        }else {
            try{
              
		 if(!checkAccontNo(pinText.getText()))
                    JOptionPane.showMessageDialog(null,"This account does not exist");
                else{
                    
                 Connection c=Conn.Conn();
                        String qry1="delete from login where pinNo=?";
                        String qry2="delete from bank  where pin=?";
                    

                        PreparedStatement ps1=c.prepareStatement(qry1);
                        ps1.setString(1,pinnumber);
                        
     
                        PreparedStatement ps2=c.prepareStatement(qry2);
			ps2.setString(1,pinnumber);
	
                        int a=ps1.executeUpdate();
                        int b=ps2.executeUpdate();
			if(a >=1 && b  >= 1)
                               JOptionPane.showMessageDialog(null,"Deleted successfully");
			else
                         JOptionPane.showMessageDialog(null,"not delete");
                        
                    }       
            }catch(Exception e){
                System.out.println(e);
            }
        }
   }   
    
    public static void main(String[] args) {
        new CloseAccount(" ");
    }
    
}
