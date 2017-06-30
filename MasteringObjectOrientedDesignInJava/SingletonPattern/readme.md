#### Singleton Pattern
- When you want to instantiate a class no more than once.
- The key is they should NOT have a public constructor, and have a static getInstance() method instead.
```java
    private static SomeClass INSTANCE = null;
    private SomeClass() {}; 

    // synchronized to make thread safe
    public synchronized static SomeClass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SomeClass();
        }
        return INSTANCE;
    }
```.
