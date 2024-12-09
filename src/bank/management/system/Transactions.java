
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener {
    JButton deposite,withrawl,ministatement,pinchange,fastcash,balancenqueiry,exit,closeAccount;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("please select your Transection");
        text.setBounds(200,300,300,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(150,415,130,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        
        withrawl=new JButton("case withrawl");
        withrawl.setBounds(390,415,130,30);
        withrawl.addActionListener(this);
        image.add(withrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(150,450,130,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
       ministatement =new JButton("Mini Statement");
       ministatement.setBounds(390,450,130,30);
       ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinchange=new JButton("Pinchange");
        pinchange.setBounds(150,485,130,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balancenqueiry=new JButton("Balance Enquiry");
        balancenqueiry.setBounds(390,485,130,30);
        balancenqueiry.addActionListener(this);
        image.add(balancenqueiry);
        
        exit=new JButton("Exit");
        exit.setBounds(390,520,130,30);
        exit.addActionListener(this);
        image.add(exit);
        
     
        closeAccount=new JButton("Close Account");
        closeAccount.setBounds(150,520,130,30);
        closeAccount.addActionListener(this);
        image.add(closeAccount);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit)
            System.exit(0);
        else if(e.getSource()==deposite){
            dispose();
            new Deposit(pinnumber).setVisible(true);
        }  
            else if(e.getSource()==withrawl){
            dispose();
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(e.getSource()==fastcash){
            dispose();
            new FastCash(pinnumber).setVisible(true);
        }
        else if(e.getSource()==pinchange){
            dispose();
            new PinChange(pinnumber).setVisible(true);
        }
        else if(e.getSource()==balancenqueiry){
            dispose();
            new BalanceEnquery(pinnumber).setVisible(true);
        }
        else if(e.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
        else if(e.getSource()==closeAccount){
            new CloseAccount(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
      new Transactions(""); 
    }
    
}
