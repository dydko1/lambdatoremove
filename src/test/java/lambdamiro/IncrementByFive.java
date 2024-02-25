package lambdamiro;

import org.testng.annotations.Test;

public class IncrementByFive {

    @Test
    public void incrementByFive() {
        IncrementByFiveInterface incrementByFiveInterface = x -> x + 5;
        System.out.println(incrementByFiveInterface.incrementByFive(10));
    }
}
