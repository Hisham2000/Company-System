
package App.Controllers.Auth;

import java.sql.*;
import App.Models.Model;
import javax.swing.JOptionPane;
import Resources.Views.Auth.Register;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterController {

    Model model = new Model();
    
    public RegisterController()
    {
        // return the register view
        model.setTable("employee");
    }
    
    public void create()
    {
        try {
            ResultSet resultSet = model.all();
            Register register = new Register(resultSet);
            register.setVisible(true);
            register.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "there was an error while get an employies data");
        }
        
    }
    
    public void add(String name, String email, String password, int salary, String role, int role_id)
    {
        try {
            int numEmployee = model.addEmployee(name, email, password, salary, role, role_id);
            JOptionPane.showMessageDialog(null, "The Member added successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There was an error occured pls try again later");
        }
    }
}
