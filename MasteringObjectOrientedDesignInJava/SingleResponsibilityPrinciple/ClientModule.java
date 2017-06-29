import java.sql.Connection;

// According to Imtiaz, this class still has a lot of responsibility
// Other modules might be HR module and Reporting module and User module
// Also, it is very tightly coupled to Employee internals. 
//     Ref: EmployeeDAO and EmployeeReportFormatter instantiation.
// For now, this is what we work with though.
public class ClientModule {

    // Since the UML doesn't not contain these associations, they are removed
    //static EmployeeDAO employeeDAO;    
    //static EmployeeReportFormatter empRF;

    public static void hireNewEmployee(Employee emp) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.saveEmployee(emp);
        System.out.println("Created new employee "+emp.name);
    }

    public static void terminateEmployee(Employee emp) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.deleteEmployee(emp);
        System.out.println("Deleted employee "+emp.name);
    }

    public static void printEmployeeReport(Employee emp, FormatType f) {
        EmployeeReportFormatter empRF = new EmployeeReportFormatter(emp, f);
        empRF.getFormattedEmployee();
    }

    public static void main(String args[]) throws Exception {

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

        printEmployeeReport(employee2, FormatType.CSV);
        printEmployeeReport(employee3, FormatType.XML);

        terminateEmployee(employee1);
        terminateEmployee(employee5);
    }

}
