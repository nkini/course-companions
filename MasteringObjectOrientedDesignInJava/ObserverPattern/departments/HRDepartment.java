package departments;

import databases.Employee;

public class HRDepartment implements IObserver {

    public void callMe(String message, Employee emp) {
        System.out.println("HR Department was notified");
        System.out.println(message + " : " + emp.getName());
    }

}
