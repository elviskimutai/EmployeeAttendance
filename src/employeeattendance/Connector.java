
package employeeattendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kim
 */
public class Connector {
      Connection con=null;
  
      public static Connection ConnecrDB(){
          
          try{
    // Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeattendance","root","KIMkim100%");
     return con;
} catch(SQLException e){
 e.printStackTrace();
 return null;
}
      }
}
