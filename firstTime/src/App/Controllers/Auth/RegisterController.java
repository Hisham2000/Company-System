
package App.Controllers.Auth;

import java.sql.*;
import App.Models.Model;
import javax.swing.JOptionPane;

public class RegisterController {

    Model model = new Model();
    
    public RegisterController()
    {
        // return the register view
        model.setTable("employee");
    }
    
    public void add(String name, String email, String password, String role)
    {
        try {
            int numEmployee = model.addEmployee("Mohamed", "Mohamed@gmail.com", "123456789", "PM");
             JOptionPane.showMessageDialog(null, "The Member added successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There was an error occured pls try again later");
        }
    }
}
