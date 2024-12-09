
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Signup2 extends JFrame implements ActionListener{
    JRadioButton noo,yess,no,yes;
    JTextField pan,aadhar;
    JComboBox reli,cat,in,qual,occu;
    String random;
    Signup2(String random){
        this.random=random;
        setSize(900,800);
        setLocation(450,10);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2 ");
        setLayout(null);
        
        JLabel Additionaldetail=new JLabel("Page 2: Additionnal Detail");
        Additionaldetail.setFont(new Font("railway",Font.BOLD,28));
        Additionaldetail.setBounds(250,10,400,50);
        add(Additionaldetail);
   
        JLabel Religion=new JLabel("Religion");
        Religion.setFont(new Font("railway",Font.BOLD,20));
        Religion.setBounds(80,90,100,30);
        add(Religion);
        
        String valreligion[]={"hindu","muslim","sikh","christan","other"};
         reli=new JComboBox(valreligion);
        reli.setBackground(Color.white);
        reli.setBounds(300,90,300,30);
        add(reli);
        
        
        JLabel category=new JLabel("Category");
        category.setFont(new Font("railway",Font.BOLD,20));
        category.setBounds(80,150,100,30);
        add(category);
        
        String valcategory[]={"General","OBC","SC","ST","other"};
        cat=new JComboBox(valcategory);
        cat.setBackground(Color.white);
        cat.setBounds(300,150,300,30);
        add(cat);
        
        
        JLabel income=new JLabel("Income");
        income.setFont(new Font("railway",Font.BOLD,20));
        income.setBounds(80,200,100,30);
        add(income);
        
        String salcategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,0000"};
        in=new JComboBox(salcategory);
        in.setBounds(300,200,300,30);
       in.setBackground(Color.white);
       add(in);
        
        JLabel quali=new JLabel("Qualification" );
        quali.setFont(new Font("railway",Font.BOLD,20));
        quali.setBounds(80,250,200,30);
        add(quali);
        
 
       String qualival[]={"Non Graduate","Graduate","Post Graduate","Other"};
       qual=new JComboBox(qualival);
       qual.setBounds(300,250,300,30);
       qual.setBackground(Color.white);
       add(qual);
       
       
        JLabel Occupation=new JLabel("Occupation" );
        Occupation.setFont(new Font("railway",Font.BOLD,20));
        Occupation.setBounds(80,300,200,30);
        add(Occupation);
        
    
        String occuval[]={"Salaried","Self Employed","Business","Student","Retired","other"};
        occu=new JComboBox(occuval);
        occu.setBounds(300,300,300,30);
        occu.setBackground(Color.white);
        add(occu);
        
  
        JLabel panno =new JLabel("Phone Number" );
        panno.setFont(new Font("railway",Font.BOLD,20));
        panno.setBounds(80,350,200,30);
        add(panno);
        
       pan=new JTextField();
      pan.setBounds(300,350,300,30);
      add(pan);
      
        
        JLabel aadharno=new JLabel("Adhar Number" );
        aadharno.setFont(new Font("railway",Font.BOLD,20));
        aadharno.setBounds(80,400,200,30);
        add(aadharno);
        
         aadhar=new JTextField();
        aadhar.setBounds(300,400,300,30);
        add(aadhar);
      
        
        JLabel citizen=new JLabel("Sinear Citizen" );
        citizen.setFont(new Font("railway",Font.BOLD,20));
        citizen.setBounds(80,450,200,30);
        add(citizen);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(300,450,50,30);
        yes.setBackground(Color.white);
        add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(450,450,50,30);
        no.setBackground(Color.white);
        add(no);
        
        ButtonGroup citizengrp=new ButtonGroup();
        citizengrp.add(no);
        citizengrp.add(yes);
        
        
        
        JLabel account=new JLabel("Existing Account" );
        account.setFont(new Font("railway",Font.BOLD,20));
        account.setBounds(80,500,200,30);
        add(account);

         yess=new JRadioButton("yes");
        yess.setBounds(300,500,50,30);
        yess.setBackground(Color.white);
        add(yess);

        noo=new JRadioButton("No");
        noo.setBounds(450,500,50,30);
        noo.setBackground(Color.white);
        add(noo);
        
        
        ButtonGroup accountgrp=new ButtonGroup();
        accountgrp.add(noo);
        accountgrp.add(yess);
        
        JButton nextbutton=new JButton("Next");
        nextbutton.setBounds(550,650,100,30);
        nextbutton.setForeground(Color.white);
        nextbutton.setBackground(Color.black);
        add(nextbutton);
       nextbutton.addActionListener(this);
 
    }
    public void actionPerformed(ActionEvent e){
        try{
            Connection c= Conn.Conn();
           PreparedStatement ps=c.prepareStatement("insert into signuptwo values(?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1,random);
            ps.setString(2, (String)reli.getSelectedItem());
            ps.setString(3, cat.getSelectedItem().toString());
            ps.setString(4,in.getSelectedItem().toString());
            ps.setString(5, (String)qual.getSelectedItem());
            ps.setString(6, (String)occu.getSelectedItem());
            ps.setString(7, pan.getText());
            ps.setString(8, aadhar.getText());
            String scitizen=null;
            if(yes.isSelected())
                scitizen="Yes";
            else
                scitizen="No";
            
            String eaccount=null;
            if(yess.isSelected())
                eaccount="yes";
            else
                eaccount="No";
                       
            ps.setString(9,scitizen);
            ps.setString(10, eaccount);
           
            int a=ps.executeUpdate();
            if(a==1){
              JOptionPane.showMessageDialog(null,"Succesfully submited");
                //setVisible(false);
               dispose();
                new Signupthree(random).setVisible(true);
            }
            else
               JOptionPane.showMessageDialog(null,"Some error");


            
        }catch(Exception ev){
            System.out.println(ev);
        }
    }
  public static void main(String args[]){
      new Signup2("");
  }  
}
