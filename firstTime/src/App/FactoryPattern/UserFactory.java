
package App.FactoryPattern;

import App.Controllers.*;

public class UserFactory {
    
    public static User getUser(String type)
    {
        if(type == null) return null;
        else if(type.equalsIgnoreCase("Employee")) return new EmployeeController();
        else if(type.equalsIgnoreCase("TeamLeader")) return new TeamLeaderController();
        else if(type.equalsIgnoreCase("Admin")) return new AdminController();
        else if(type.equalsIgnoreCase("ProjectManager")) return new ProjectManagerController();
        return null;
    }
    
}
