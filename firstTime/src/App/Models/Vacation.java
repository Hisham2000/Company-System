
package App.Models;

import  java.sql.*;

public class Vacation extends Model{

    public Vacation() {
        this.setTable("vacation");
    }
    
    public void store(int user_id, String from, String to) throws SQLException
    {
        String query = "INSERT INTO `vacation`(`employee_id`, `from`, `to`) VALUES ("+ user_id +",'"+from+"','"+to+"')";
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(query);
    }
    
    
}
