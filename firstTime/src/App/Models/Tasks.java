
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
    
    public void create(int projectId, int userId, String description) throws SQLException
    {
        String query = "INSERT INTO `tasks`( `project_id`, `description`, `user_id`, `action`) VALUES ("+ projectId +", '"+ description +"',"+ userId +" ,'Start')";
        Statement statement = this.connection.createStatement();
        int resultSet = statement.executeUpdate(query);
    }
    
    public ResultSet getFinshedTasks() throws SQLException
    {
        String query = "SELECT employee.name As 'User Name', project.name As 'Project Name', tasks.description As 'Task Description' FROM tasks INNER JOIN employee ON tasks.user_id = employee.id INNER JOIN project ON tasks.project_id = project.id WHERE tasks.action = 'Finish';  ";
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return  resultSet;
    }
    
    
    public ResultSet getTaskForEmbloyee(int userId) throws SQLException
    {
        String query = "select tasks.id, tasks.description, project.name, tasks.action FROM tasks INNER JOIN project ON tasks.project_id = project.id WHERE tasks.user_id = "+userId+" AND tasks.action = 'Start'; ";
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }
    
    public void markAsFinished(int taskId) throws SQLException
    {
        String query = "UPDATE `tasks` SET `action` = 'Finish' WHERE id = "+ taskId;
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(query);
    }
}
