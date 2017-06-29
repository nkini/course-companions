package departments;

public class HRDepartment implements IObserver {

    public void callMe(String message) {
        System.out.println("HR Department was notified: " + message);
    }

}
