
package App.Controllers;

import App.Models.Vacation;
import Resources.Views.Employee.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import App.Controllers.Auth.LoginController;

public class VacationController {
    
    public void index()
    {
        RequestVacation requestVacation = new RequestVacation();
        requestVacation.setVisible(true);
        requestVacation.setLocationRelativeTo(null);
    }
    
    public void store(String from, String to)
    {
        try {
            Vacation vacation = new Vacation();
            vacation.store(Integer.parseInt(LoginController.Auth.get("id")), from, to);
            EmployeeController employeeController = new EmployeeController();
            employeeController.index();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Your Vacation Request doesnot created");
        }
    }
}
