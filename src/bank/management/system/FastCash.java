
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
    JButton hundred,fiveh,twothausand,fivethoudsand,thousand,tenthoudsand,back;
    String pinnumber;
   FastCash(String pinnumber){
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
        
        JLabel text=new JLabel("select Withdrawl amount");
        text.setBounds(200,300,300,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        hundred=new JButton("Rs 100");
        hundred.setBounds(150,415,130,30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        
        fiveh=new JButton("Rs 500");
        fiveh.setBounds(390,415,130,30);
        fiveh.addActionListener(this);
        image.add(fiveh);
        
        thousand=new JButton("Rs 1000");
        thousand.setBounds(150,450,130,30);
        thousand.addActionListener(this);
        image.add(thousand);
        
       twothausand =new JButton("Rs 2000");
       twothausand.setBounds(390,450,130,30);
       twothausand.addActionListener(this);
        image.add(twothausand);
        
        
        fivethoudsand=new JButton("RS 5000");
        fivethoudsand.setBounds(150,485,130,30);
        fivethoudsand.addActionListener(this);
        image.add(fivethoudsand);
        
        tenthoudsand=new JButton("Rs 10000");
        tenthoudsand.setBounds(390,485,130,30);
        tenthoudsand.addActionListener(this);
        image.add(tenthoudsand);
        
        back=new JButton("Back");
        back.setBounds(390,520,130,30);
        back.addActionListener(this);
        image.add(back);
        
     
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)e.getSource()).getText().substring(3);
            try{
                //int balance=0;
            Connection c=Conn.Conn();
            PreparedStatement ps=c.prepareStatement("select * from bank where pin='"+pinnumber+"'");
            
            ResultSet rs=ps.executeQuery();
                            int balance=0;

            while(rs.next()){
                if( rs.getString("type").equals("Deposit"))
                    balance += Integer.parseInt(rs.getString("amount"));
                else
                    balance -= Integer.parseInt(rs.getString("amount"));
            }
                   if(e.getSource()!=back&& balance<Integer.parseInt(amount)){
                       JOptionPane.showMessageDialog(null, "Insufficient Balance");
                       return;
                   }
                  Date date=new Date();
                  PreparedStatement ps2=c.prepareStatement("insert into bank values(?,?,?,?)");
                  ps2.setString(1,pinnumber);
                  ps2.setString(2,date.toString());
                  ps2.setString(3,"withdrawl");
                  ps2.setString(4,amount);
                  
                  int a=ps2.executeUpdate();
                  if(a==1)
                      JOptionPane.showMessageDialog(null,"Rs "+ amount + " Debited Sucessfully ");
                  
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
            }catch(Exception ae){
                System.out.println(ae);
            }  
        }
    }
    
    public static void main(String[] args) {
      new FastCash(""); 
    }
    
}
