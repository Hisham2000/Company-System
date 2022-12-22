
package App.Models;

import java.sql.*;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class Presence extends Model{
    
    public Presence()
    {
        this.setTable("presence");
    }
    
    public void create(int userId) throws SQLException
    {
        LocalDate date = LocalDate.now();
        Date time = new Date();
        String hours = time.getHours()+":"+ time.getMinutes()+":"+time.getSeconds();
        String query = "INSERT INTO `presence`(`employee_id`, `entry_time`, `data`) VALUES ("+ userId +",'"+ hours+ "','"+date+"')";
        Statement statement = this.connection.createStatement();
        int resultset = statement.executeUpdate(query);
    }
    
    public void leave(int userId) throws SQLException
    { 
        Date time = new Date();
        String hours = time.getHours()+":"+ time.getMinutes()+":"+time.getSeconds();
        String query = "UPDATE `presence` SET `leave_time` = '"+ hours + "' WHERE employee_id = "+ userId;
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(query);
    }
}
