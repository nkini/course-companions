Dependency inversion happens when higher level modules depend on lower level modules that are susceptible to change.

Avoid tight coupling.

- High level modules should not depend on low level modules.
- Both should depend on abstractions,
- Abstractions should not depend on details. Details should depend on abstractions.

Example:
```java
abstract public class Employee {
    abstract public void performDuties();
}
```
Being abstract forced the sub classes (Doctor, Nurse) to define their own performDuties method. So *other* classes could depend on the abstract idea of employees working when sent the perform duties message. If the specific details of their duties changed, the clients would remain unaffected in terms of what message to send.

Key Idea: Abstract Classes and Interfaces don't change as often as concrete derivatives.

### Template method design pattern
- Often used in abstracting the workflow common across many objects
- Abstract methods implemented in subclasses, but called in abstract class as part of generally defined process or flow.
- A behavioral pattern, defines program skeleton in the method called the template method.


### Cohesion
- Keep related things corresponding to the same higher level concept together.
- Package names should correspond to important high level concepts.
- Package design should have high cohesion as a goal.
- A package should have a single feature, analogous to classes should have a single responsibility.
