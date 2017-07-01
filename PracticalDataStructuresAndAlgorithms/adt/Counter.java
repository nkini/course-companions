package adt;

public class Counter {

    String name;
    int counter = 0;

    public Counter(String str) {
        this.name = str;
    }

    public void increment() {
        ++counter;
    }

    public int getCurrentValue() {
        return counter;
    }

    public String toString() {
        return "Counter[name=" + name + ", value=" + counter + "]";
    }

}
