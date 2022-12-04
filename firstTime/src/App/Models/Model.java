
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
    
    
    

}
