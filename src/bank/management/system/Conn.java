//register driver
//create connection 
//create statement
// execute query
//close connection
package bank.management.system;
import java.sql.*;
public class Conn {
   static Connection c=null;
    public static Connection Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
          c=DriverManager.getConnection("jdbc:mysql:///bankm","root","hello");
           
        }catch(Exception e){
            System.out.println(e);
        }
    return c;
    }
}
    
    

