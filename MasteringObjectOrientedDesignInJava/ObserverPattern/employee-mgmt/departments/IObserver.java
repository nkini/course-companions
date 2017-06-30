package departments;

import databases.Employee;

public interface IObserver {

    public void callMe(String message, Employee emp);

}
