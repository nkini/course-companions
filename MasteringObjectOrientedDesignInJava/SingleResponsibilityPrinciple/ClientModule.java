import java.sql.Connection;

public class ClientModule {

    static EmployeeDAO employeeDAO;
    static EmployeeReportFormatter empRF;

    public static void hireNewEmployee(Employee emp) {
        employeeDAO.saveEmployee(emp);
        System.out.println("Created new employee "+emp.name);
    }

    public static void terminateEmployee(Employee emp) {
        employeeDAO.deleteEmployee(emp);
        System.out.println("Deleted employee "+emp.name);
    }

    public static void printEmployeeReport(Employee emp, EmployeeReportFormatter.FormatType f) {
        empRF = new EmployeeReportFormatter(emp, f);
        empRF.getFormattedEmployee();
    }

    public static void main(String args[]) throws Exception {
        DatabaseConnectionManager dbmgr = DatabaseConnectionManager.getManagerInstance();
        employeeDAO = new EmployeeDAO(dbmgr);

        Employee employee1 = new Employee(1001, "emp1", "geriatric", false);
        hireNewEmployee(employee1);
        Employee employee2 = new Employee(1002, "emp2", "emergency", true);
        hireNewEmployee(employee2);
        Employee employee3 = new Employee(1003, "emp3", "cats", true);
        hireNewEmployee(employee3);
        Employee employee4 = new Employee(1004, "emp4", "triathlon injuries", true);
        hireNewEmployee(employee4);
        Employee employee5 = new Employee(1005, "who", "doctor", true);
        hireNewEmployee(employee5);

        printEmployeeReport(employee2, EmployeeReportFormatter.FormatType.CSV);
        printEmployeeReport(employee3, EmployeeReportFormatter.FormatType.XML);

        terminateEmployee(employee1);
        terminateEmployee(employee5);

        dbmgr.disconnect();
    }

}
