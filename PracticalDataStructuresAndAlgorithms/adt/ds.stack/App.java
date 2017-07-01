public class App {
    public static void main(String[] args) {
        /*
        Stack theStack = new Stack(3);
        //theStack.push(20);
        //theStack.push(40);
        //theStack.push(60);
        //theStack.push(80);

        while(!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.println(value);
        }*/
        
        String string = "qwertyuiop";
        System.out.println("The string: " + string);
        System.out.println("Reversed  : " + reverseString(string));

    }

    public static String reverseString(String string) {

        Stack stringStack = new Stack(string.length());

        for(int i = 0; i < string.length(); i++) {
            stringStack.push(string.charAt(i));
        }

        /*for (char c : string) {
            stringStack.push(c);
        }*/

        String reversedString = "";

        while(!stringStack.isEmpty()) {
            reversedString += stringStack.pop();
        }

        return reversedString;
    }
}
