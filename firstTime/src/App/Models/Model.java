 
package App.Models;

import java.sql.*;
import Database.config;
import javax.swing.JOptionPane;

public class Model {
    protected String table;
    
    private Connection connection = config.get_Instance();
    
    public void setTable(String table)
    {
        this.table = table;
    }
    
    public ResultSet all() throws SQLException
    {
        String query = "SELECT * FROM "+this.table;
        Statement statement = this.connection.createStatement() ;
        ResultSet result = statement.executeQuery(query);
        return result;
    }
    
    public ResultSet find(int id) throws SQLException
    {
        String query = "SELECT * FROM "+this.table+" WHERE id = "+id;
        Statement statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        return result;
    }
    
    public void delete(int id) throws SQLException
    {
        String query = "DELETE FROM "+this.table+" WHERE id = "+id;
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(query);
    }
    
    public ResultSet chick(String email, String password, String role) throws SQLException
    {
        String query = "SELECT * FROM "+this.table+" WHERE email = '"+email+"' And password = '"+password+"' And role = '"+role+"';";
        Statement statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        return result;
    }
    
    public int addEmployee(String name, String email, String password, int salary, String role, int role_id) throws SQLException
    {
//        INSERT INTO `employee`(`id`, `name`, `email`, `password`, `salary`, `role`, `role_id`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]')
        String query = "INSERT INTO `employee` ( name, email, password, salary, role, role_id ) VALUES('" + name + "', '"+email+"', '"+password+"', "+salary+", '"+role+"', "+role_id+")";
        Statement statement = this.connection.createStatement();
        int result = statement.executeUpdate(query);
        return result;
    }
    
    public void update(int id, String name, String email, String password, int salary, String role, int role_id)
    {
        try
        {
            String query = " UPDATE "+this.table+
                " SET name = '"+name+"', "+
                "email = '"+email+"', "+
                "password = '"+password+"', "+
                "salary = "+salary+", "+
                "role = '"+role+"', "+
                "role_id = "+role_id+
                " WHERE id = "+id;
            Statement statement = this.connection.createStatement();
            int resultSet = statement.executeUpdate(query);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Sorry your update dioesnot work pls make it will");
        }
            
    }
    

}
