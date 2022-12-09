
package App.Models;

import java.sql.*;
import Database.config;

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
    
    public int addEmployee(String name, String email, String password, String role) throws SQLException
    {
        String query = "INSERT INTO `employee` VALUES('" + name + "', '"+email+"', '"+password+"', '"+role+"')";
        Statement statement = this.connection.createStatement();
        int result = statement.executeUpdate(query);
        return result;
    }
    

}
