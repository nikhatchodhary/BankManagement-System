
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton clear,login,signup;
    JTextField cardTextfield;
    JPasswordField pinTextfield;
    JCheckBox checkbox;
    Login(){
     
        setSize(800,500);
       setVisible(true);
       setLocation(300,200);
       setTitle("AOTOMATED TURNING MACHINE");
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
       Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel label=new JLabel(i3);
       label.setBounds(70,10,100,100);
       add(label);
       JLabel text=new JLabel("Welcome to ATM");
       add(text);
       text.setBounds(210,40,500,40);
       text.setFont(new Font("Osward",Font.BOLD,38));
       getContentPane().setBackground(Color.white);
       
       JLabel cardno=new JLabel("Enter  Card No:");
       add(cardno);
       cardno.setBounds(120,150,200,40);
       cardno.setFont(new Font("Raleway",Font.BOLD,25));
        cardTextfield=new JTextField();
       cardTextfield.setBounds(400,150,250,30);
       cardTextfield.setFont(new Font("Osward",Font.BOLD,20));

       add(cardTextfield);
       JLabel pin=new JLabel("Enter PIN :");
       add(pin);
       pin.setBounds(120,230,200,40);
       pin.setFont(new Font("Osward",Font.BOLD,25));
       
        pinTextfield=new JPasswordField();
       pinTextfield.setBounds(400,230,250,30);
       pinTextfield.setFont(new Font("Osward",Font.BOLD,20));
       add(pinTextfield);
       
       checkbox=new JCheckBox("Show pin");
       checkbox.setBounds(450,280,150,30);
       add(checkbox);
       checkbox.addActionListener(this);
        
       login=new JButton("SIGN IN");
       login.setBounds(120,320,100,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.white);
       add(login);
       login.addActionListener(this);
       
       signup=new JButton("SIGN UP");
       signup.setBounds(270,320,100,30);
       signup.setBackground(Color.BLACK);
       signup.setForeground(Color.white);
       add(signup);
       
       signup.addActionListener(this);
       clear=new JButton("CLEAR");
       clear.setBounds(120,370,230,30);
       clear.setBackground(Color.BLACK);
       clear.setForeground(Color.white);
       add(clear);
       clear.addActionListener(this);
       
       
    }
    public void actionPerformed(ActionEvent e){
        if(checkbox.isSelected()==true){
           pinTextfield.setEchoChar((char)0);
       }
       else{
           pinTextfield.setEchoChar('.');
       }
       
        if(e.getSource()==clear){
            cardTextfield.setText("");
            pinTextfield.setText("");
            
        }else if(e.getSource()==login){
            Connection c=Conn.Conn();
        
            String pinnumber=pinTextfield.getText();
          try{
           PreparedStatement ps=c.prepareStatement("select* from login where cardnumber=?and pinNo=?");
           ps.setString(1,cardTextfield .getText());
           ps.setString(2,pinTextfield.getText());
           ResultSet rs=ps.executeQuery();
       
           if(rs.next()){
                setVisible(false);
                dispose();
                new Transactions(pinnumber).setVisible(true);
               }
            
           else if(pinnumber.equals(" "))
                JOptionPane.showMessageDialog(null,"missing pin or cardnumber");
                
           else
               JOptionPane.showMessageDialog(null,"incorrect pin or cardnumber");

                
            }catch (Exception ae){
                System.out.println(ae);
            }
            		

            
        }else if(e.getSource()==signup){
            new SignupOne().setVisible(true);
            
        }
        
    }

    public static void main(String[] args) {
        new Login();
        
    }
    
}
