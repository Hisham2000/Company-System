
package App.Controllers;

import App.Controllers.Auth.RegisterController;
import App.Models.Admin;
import Resources.Views.Admin.AllProjects;
import App.Models.Projects;
import java.sql.*;
import javax.swing.JOptionPane;
import Resources.Views.Admin.Index;
/**
 *
 * @author EtchEGo
 */
public class AdminController {
    
    Admin admin = new Admin();
    
    public  AdminController()
    {
        Index index = new Index();
        index.setVisible(true);
        index.setLocationRelativeTo(null);
    }
    
    public void allProjects()
    {
        try {
            Projects projects = new Projects();
            ResultSet resultSet =  projects.all();
            AllProjects allProjects = new AllProjects(resultSet);
            allProjects.setVisible(true);
            allProjects.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sorry this was an error occured while we tryig to get the projects pls try again");
        }
    }
    
    public void delte(int id)
    {
        try {
            admin.setTable("employee");
            admin.delete(id);
            RegisterController registerController = new RegisterController();
            registerController.create();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cant delete this Worker now pls try again later");
        }
    }
    
    public void update(int id, String name, String email, String password, int salary, String role, int role_id)
    {
        admin.setTable("employee");
        admin.update(id, name, email, password, salary, role, role_id);
        RegisterController registerController = new RegisterController();
        registerController.create();
    }
}
