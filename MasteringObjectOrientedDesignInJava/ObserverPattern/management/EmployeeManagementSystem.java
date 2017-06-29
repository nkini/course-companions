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

    // I'm not sure what's the better thing to do...
    // In the Instructor solution, we have no arguments, and instance variables for message and employee.
    // I, however, feel like this is more transparent.
    public void notifyAllDepartments(String message, Employee employee) {
        for (IObserver observer : observerList) {
            observer.callMe(message, employee);
        }
    }


    public void registerObserver(IObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(IObserver observer) {
        // Didn't know you could so easily remove an object from a List
        observerList.remove(observer);
    }


    public void hireNewEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
        // While I like the format of this message better,
        //     I do feel like the notification should come from the departments...
        //     But then judging by the repeated code in the departments, 
        //     I think I like the older design with the prints here.
        //System.out.println("\nNew hire: " + employee.getName());
        notifyAllDepartments("New employee added", employee);
    }


    public void modifyEmployeeName(int id, String newName) {
        boolean employeeFound = false;
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                String oldName = employee.getName();
                employee.setName(newName);
                // While I like the format of this message better,
                //     I do feel like the notification should come from the departments...
                // System.out.println("\nEmployee name changed from " + oldName + " to " + newName);
                notifyAllDepartments("Employee name modified", employee);
                employeeFound = true;
                break;
            }
        }
        if (!employeeFound) {
            System.out.println("\nEmployee ID " + id + " does not exist.");
        }
    }

}
