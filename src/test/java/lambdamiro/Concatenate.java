package lambdamiro;

import org.testng.annotations.Test;

public class Concatenate {
    private static final String TEMPLATE = "%s xxx %s";

    @Test
    public void concatenate() {
        IConcatenate iConcatenate = (x, y) -> String.format(TEMPLATE, x, y);

        System.out.println(iConcatenate.concatenate("aaa", "cccc"));
    }
}
