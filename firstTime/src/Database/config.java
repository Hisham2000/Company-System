
package Database;

import java.sql.*;
import javax.swing.JOptionPane;

public class config {
    
    private static String dbName = "pl3project";
    private static String userName = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/pl3project "
                + "?useUnicode=true&characterEncoding=UTF-8";
    private static Connection get_Instance = null;
    private config()
    {
        
    }
    
    public static Connection get_Instance()
    {
        if(config.get_Instance == null)
        {
            config.setConnection();
            return config.get_Instance;
        }
        return config.get_Instance;
    }
    
    private static void setConnection()
    {
        try
        {   
            config.get_Instance = DriverManager.getConnection(config.url, config.userName, config.password);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "The Connection to database Has been faild");
        }
    }
}
