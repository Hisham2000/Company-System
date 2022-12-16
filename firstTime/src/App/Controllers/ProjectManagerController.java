
package App.Controllers;

import Resources.Views.ProjectManager.*;
import java.sql.*;
import App.Models.*;
import javax.swing.JOptionPane;

public class ProjectManagerController {
    
    public void index()
    {
        PMindex pmIndex = new PMindex();
        pmIndex.setVisible(true);
        pmIndex.setLocationRelativeTo(null);
    }
    
    public void projectProgress()
    {
        PMProjectProgress pMProjectProgress = new PMProjectProgress();
        pMProjectProgress.setVisible(true);
        pMProjectProgress.setLocationRelativeTo(null);
    }
    
    public void getCountAllTasks(int project_id)
    {
        try
        {
            Tasks tasks = new Tasks();
            ResultSet resultSet = tasks.count(project_id);
            resultSet.next();            
            int count = resultSet.getInt("countRow");
            JOptionPane.showMessageDialog(null, "You have "+count+" tasks in this project");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "The project is not found pls enter the valid project number");
        }
    }
    
    public void createReport(int user_id, String report)
    {
        try
        {
            Report reportModel = new Report();
            reportModel.createReport(user_id, report);
            JOptionPane.showMessageDialog(null, "The Report Created Successfully");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Sory the report doesnot created pls try again with specific data");
        }
    }
    
    
}
