
package App.Controllers;

import java.sql.*;
import App.Models.*;
import Resources.Views.Employee.EmployeeAttendence;
import App.Controllers.Auth.LoginController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PresenceController {
    
   
    public void index() {
        EmployeeAttendence employeeAttendence = new EmployeeAttendence();
        employeeAttendence.setVisible(true);
        employeeAttendence.setLocationRelativeTo(null);
    }
    
    public void presence()
    {
        try {
            Presence presence = new Presence();
            presence.create(Integer.parseInt(LoginController.Auth.get("id")));
            EmployeeController employeeController = new EmployeeController();
            employeeController.index();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "We doesnot make your presence");
        }
    }
    
    public void leave()
    {
        try{
            Presence presence = new Presence();
            presence.leave(Integer.parseInt(LoginController.Auth.get("id")));
            EmployeeController employeeController = new EmployeeController();
            employeeController.index();
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "YOur Leave Doesnot Saved");
        }
        
    }
}
