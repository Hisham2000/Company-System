
package App.Controllers;

import App.FactoryPattern.User;
import Resources.Views.TeamLeader.*;

public class TeamLeaderController implements User{
    
    public void index()
    {
        ALL all = new ALL();
        all.setVisible(true);
        all.setLocationRelativeTo(null);
    }
}
