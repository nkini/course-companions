Open Closed Principle:  
- Software Modules should be *open* for **extension** and *closed* for **modification**.

Example:

```java
// Junk Drawer of behaviors
public class HospitalManagement {

    // Red Flag 1: Behaviors that should really have been defined in
    //     Doctor and Nurse appear here.
    // Red Flag 2: When you add other employees, you will need to modify this class
    // This is a violation of the OCP. Modules should be closed for modification.
    public void callUpon(Employee employee) {

        if (employee instanceof Nurse){
            checkVitalSigns();
            drawBlood();
            cleanPatientArea();
        }
        else if (employee instanceof Doctor ){
            prescribeMedicine();
            diagnosePatients();
        }
 
    }


    // Doctors
    private void prescribeMedicine(){
        System.out.println("Prescribe Medicine");
    }
     
    private void diagnosePatients(){
        System.out.println("Diagnosing Patient");
    }

    // Nurses
    private void checkVitalSigns(){
        System.out.println("Checking Vitals");
    }
     
    private void drawBlood(){
        System.out.println("drawing blood");
    }
     
    private void cleanPatientArea(){
        System.out.println("cleaning Patient Area");
    }
 
}

```

The fix to this would look something like:

```java

public abstract class Employee {
    public abstract performDuties();
}

public class HospitalManagement {
    public void callUpon(Employee employee) {
        employee.performDuties();
    }
}
```

and is known as the Strategy Pattern.

### Strategy pattern
> Enables an algorithm's behavior to be selected at run time. This pattern lets the algorithm vary independently from the clients that use it.

Clients can now use a consistent interface to tell employees to perform their respective responsibilities without getting into the specifics of how each type of employee does them.


#### Assignment:
Source: http://www.jobreadyprogrammer.com/blog/107883/remote-control-assignment
> We're going to model a home entertainment system and the ability for a user to be able to use a single remote control to control multiple digital devices such as a TV or sound system etc. Keep in mind we only want one controller in our living room! It's a nice universal controller capable of connecting to multiple devices. This may call for using the singleton design pattern. We'll be covering that pattern more formally later in the course but I wanted to expose you to it a little early so you're better equipped for the later lesson. Google it if you have to understand how it works.
