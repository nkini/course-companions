#### Builder Pattern

API looks like so:
```java
User websiteUser = new User.builder("username","email@abc.com").build();
//or
User websiteUser = new User.builder("username","email@abc.com").build().firstName("first").lastName("last").build();
```
vs
```java
User websiteUser = new User("username","email@abc.com");
websiteUser.setFirstname("first");
websiteUser.setLastname("last");
//or there are about 3 different constructors and you choose one of those runtime
User websiteUser = new User("username","email@abc.com","first","last");
```

- Used for object construction and useful when you have a class with a constructor with a large number of arguments.
- Handy methods for object construction rather than having multiple constructors.
- What to do:
    - Private constructor in the User class, that takes in a Builder object and sets its attributes from the Bulder..
    - Have a nested Builder class with a build() method that returns a new User().
    - Have "setters" for each attribute.
- Important things to keep in mind:
    - The Builder class must be public static.
    - All methods must return the Builder.
- Two other advantages are that:
    - The code looks prettier
    - The order of which attributes you set does not matter (whereas in a constructor it does)
