package departments;

public class PayrollDepartment implements IObserver {

    public void callMe(String message) {
        System.out.println("Payroll Department was notified: " + message);
    }

}
