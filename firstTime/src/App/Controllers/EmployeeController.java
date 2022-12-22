
package App.Controllers;

import App.FactoryPattern.User;
import Resources.Views.Employee.*;

public class EmployeeController implements User{

    
    public void index()
    {
        Index index = new Index();
        index.setVisible(true);
        index.setLocationRelativeTo(null);
    }
}
