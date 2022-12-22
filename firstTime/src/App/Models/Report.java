
package App.Models;

import java.sql.*;

public class Report extends Model{
    
    public Report()
    {
        this.setTable("employee_repory");
    }
    
    public void createReport(int user_id, String report) throws SQLException
    {
        String query = "INSERT INTO `employee_repory`(`user_id`, `report`) VALUES ( "+ user_id + ",'"+ report + "')";
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(query);
    }
}
