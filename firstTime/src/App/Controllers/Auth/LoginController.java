
package App.Controllers.Auth;

import App.Controllers.AdminController;
import App.Controllers.ProjectManagerController;
import App.Models.Admin;
import java.util.ArrayList;
import App.Models.Model;
import Resources.Views.Admin.AllProjects;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Resources.Views.Auth.Login;

public class LoginController {
    
    
    // All usert Loged in Data
    public static Map<String, String> Auth = new HashMap<String, String>();
    Model model = new Model();
    
    
    
    public LoginController()
    {
        Login login =  new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
        model.setTable("employee");
    }
    
    public void check(String email, String password, String role)
    {
        try {
            ResultSet resultSet = model.chick(email, password, role.toLowerCase());
            
            if(resultSet.next())
            {
                Auth.put("id",resultSet.getString("id"));
                Auth.put("name",resultSet.getString("name"));
                Auth.put("email",resultSet.getString("email"));
                Auth.put("password",resultSet.getString("password"));
                Auth.put("role",resultSet.getString("role"));
                Auth.put("role_id",resultSet.getString("role_id"));
                Auth.put("salarty", resultSet.getString("salary"));
                this.redirect();
            }else{
                JOptionPane.showMessageDialog(null, "The Credintila not Found");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "There was an error occured please try again");
        }
    }
    
    private void redirect()
    {
        String role = Auth.get("role");
        role = role.toLowerCase();
        switch (role) {
            case "admin" -> {
                AdminController adminController = new AdminController();
            }
            case "projectmanager" -> {
                ProjectManagerController projectManagerController = new ProjectManagerController();
                projectManagerController.index();
            }
            case "team leader" -> {
            }
            default -> {
            }
        }
    }
    
    private void attempt()
    {
        // put the loged in user data in an Auth array list
    }
}
