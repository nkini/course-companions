package departments;

import databases.Employee;

public class PayrollDepartment implements IObserver {

    public void callMe(String message, Employee emp) {
        System.out.println("Payroll Department was notified");
        System.out.println(message + " : " + emp.getName());
    }

}
