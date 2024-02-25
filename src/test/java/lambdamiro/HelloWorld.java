package lambdamiro;

import org.testng.annotations.Test;

public class HelloWorld {

//    @Override
//    public String sayHelloWorld() {
//        return "Hello World1";
//    }

    @Test
    public void displayHelloWorld() {
        HelloWorldInterface helloWorldInterface = () -> "Hello World";

        System.out.println(helloWorldInterface.sayHelloWorld());
    }
}
