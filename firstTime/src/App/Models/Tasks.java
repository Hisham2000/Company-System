
package App.Models;

import java.sql.*;

public class Tasks extends Model{
    
    public Tasks()
    {
        this.setTable("tasks");
    }
    
    public ResultSet count(int project_id) throws SQLException
    {
        String query = "SELECT COUNT(*) AS countRow FROM "+this.table+" WHERE `project_id` = "+project_id;
        Statement statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        return result;
    }
}
