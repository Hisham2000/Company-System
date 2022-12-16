
package App.Controllers;

import Resources.Views.ProjectManager.*;


public class EmployeeReportController {
    
    public void createReport()
    {
        PMProjectReport pMProjectReport = new PMProjectReport();
        pMProjectReport.setVisible(true);
        pMProjectReport.setLocationRelativeTo(null);
    }
}
