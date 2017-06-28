> "Objects carry out behavior in response to messages they receive"
- The messages are really the method call on an object.

```java
public class Vehicle {
    public void startEngine() {
        System.out.println("Starting my engine");
    }
    
    public void stopEngine() {
        System.out.println("Stopping my engine");
    }
    
    public void accelerate() {
        System.out.println("Accelerating myself");
    }
}

public class App {
    public static void main(String args[]) {
        Vehicle myCar = new Vehicle();
        Vehicle anotherCar = new Vehicle();
        
        myCar.accelerate();
        anotherCar.accelerate();
    }
}
```

----
### Associations define a relationship between classes
### Dependency Association
```java
public class Driver {
    //Driver depends on Vehicle
    //This dependence is referred to as an association
    //This is a Dependency association - The Driver receives 
    //  a vehicle reference only in the scope of a drive() operation.
    //The scope is the operation, not the class in general.
    public void drive(Vehicle raceCar) {
        raceCar.accelerate();
    }
}
```
----


#### Composition Association
- Implies ownership

```java
// A particular object is composed of other objects
//    that make up the whole. If the containing object
//    ceases to exist, then the internal parts it is 
//    composed of no longer exist either.
public class Vehicle {
    //Vehicle OWNS an engine
    Engine myEngine;
    
    public Vehicle(Engine anEngine) {
        myEngine = anEngine;
    }
    
    public void operateVehicle() {
        myEngine.start();
    }
}
```
----

#### Aggregation Association
- Does not imply ownership.

```java
public class SchoolLanguageDepartment {
    //This is a composition, and these courses
    //  cease to exist when the Department shuts down
    SpanishCourse spanish;
    FrenchCourse french;
    HindiCourse hindi;
}

public class SpanishCourse {
    // The students in this registry will
    //    still exist if this course shuts down.
    // The courses don't own the student.
    // So this is an aggregation relationship.
    Student[] registeredStudents;
}

public class Student {

}
```
----

### Application behavior dictates association

```java
public class NewsPaperCompany {
    
    //NewspaperCompany depends on having a customer
    //   object to whom it can send messages.
    // NewsPaperCompany HAS_A Customer
    Customer customer;
    
    public void setCustomer(Customer aCustomer) {
        customer = aCustomer;
    }
    
}

//But this exposes an error...
    // What if the customer decides to cancel her subscription?
// Here's a better design for this kind of application behavior
// Think of the associations based on the application behavior 
//    rather than real world flow.

public class Customer {
    
    NewsPaperCompany paperCompany;
    //Customer HAS_A NewsPaperCompany
    
    public void setNewsPaperCompany(NewsPaperCompany aPaperCompany) {
        paperCompany = aPaperCompany;
    }
    
    public void cancelSubscription() {
        paperCompany.stopPaperDelivery();
    }
}
```
