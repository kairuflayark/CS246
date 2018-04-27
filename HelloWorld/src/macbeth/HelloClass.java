package macbeth;

public class HelloClass {

    public void sayHello() {
        System.out.println("Hello World");
    }

    /**
     * The main function is called first.  This will
     * give greetings.
     * @param args
     */
    public static void main(String[] args) {
        // Create an instance of the class (dynamic but no pointers)
        HelloClass hello = new HelloClass();
        // Call the sayHello function which a function in the class
        hello.sayHello();
    }
}
