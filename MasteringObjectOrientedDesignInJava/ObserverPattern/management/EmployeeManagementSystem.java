package management;

import departments.IObserver;
import databases.Employee;
import databases.EmployeeDAO;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {

    EmployeeDAO employeeDAO;
    List<Employee> employees;
    List<IObserver> observerList = new ArrayList<IObserver>();


    public EmployeeManagementSystem() {
        employeeDAO = new EmployeeDAO();
        employees = employeeDAO.generateEmployees();
    }   


    public void notifyAllDepartments(String message) {
        for (IObserver observer : observerList) {
            observer.callMe(message);
        }
    }


    public void registerObserver(IObserver observer) {
        observerList.add(observer);
    }


    public void hireNewEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
        System.out.println("\nNew hire: " + employee.getName());
        notifyAllDepartments("New employee added");
    }


    public void modifyEmployeeName(int id, String newName) {
        boolean employeeFound = false;
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                String oldName = employee.getName();
                employee.setName(newName);
                System.out.println("\nEmployee name changed from " + oldName + " to " + newName);
                notifyAllDepartments("Employee name modified");
                employeeFound = true;
                break;
            }
        }
        if (!employeeFound) {
            System.out.println("\nEmployee ID " + id + " does not exist.");
        }
    }

}
