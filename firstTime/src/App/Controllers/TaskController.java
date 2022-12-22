
package App.Controllers;

import App.Controllers.Auth.LoginController;
import Resources.Views.TeamLeader.*;
import App.Models.*;
import Resources.Views.Employee.ViewAssenedTasks;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;

public class TaskController {
    
    
    public void create()
    {
        AssignTasks assignTasks = new AssignTasks();
        assignTasks.setVisible(true);
        assignTasks.setLocationRelativeTo(null);
    }
    
    public void save(int projectId, int userId, String description)
    {
        try {
            Tasks tasks = new Tasks();
            tasks.create(projectId, userId, description);
            ALL all = new ALL();
            all.setVisible(true);
            all.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "There Was an error Occured pls try again");
        }
    }
    
    public void getAllFinshedTasks()
    {
        try{
            Tasks tasks = new Tasks();
            ResultSet resultSet = tasks.getFinshedTasks();
            CompletedTasks completedTasks = new CompletedTasks(resultSet);
            completedTasks.setVisible(true);
            completedTasks.setLocationRelativeTo(null);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "There was An error in getting finished tasks pls try again later");
        }
    }
    
    public void getSpacificTasks()
    {
        try
        {
            Tasks tasks = new Tasks();
            ResultSet resultSet = tasks.getTaskForEmbloyee(Integer.parseInt(LoginController.Auth.get("id")));
            ViewAssenedTasks viewAssenedTasks = new ViewAssenedTasks(resultSet);
            viewAssenedTasks.setVisible(true);
            viewAssenedTasks.setLocationRelativeTo(null);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "there was an error in getting your tasks");
        }
    }
    
    public void MarkOnTask(int taskId)
    {
        try
        {
            Tasks tasks = new Tasks();
            tasks.markAsFinished(taskId);
            this.getSpacificTasks();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "this action doesnot performed");
        }
    }
    
    
}
