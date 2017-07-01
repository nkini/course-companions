public class Stack {
    
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char c) {
        if (isFull()) {
            System.out.println("Stack is full. No more pushing...");
        }
        else {
            stackArray[++top] = c;
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to pop...");
            return '\n';
        }
        else {
            return stackArray[top--];
        }
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return '\n';
        }
        else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull() {
        return (maxSize-1 == top);
    }

}
