package lambdamiro;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SumOfNumberUsingCallable {
    public static int[] array = IntStream.rangeClosed(0, 5).toArray();
    public static int total = IntStream.rangeClosed(0, 5).sum();

    @Test
    public void sum() throws InterruptedException, ExecutionException {
        Callable callable1 = () -> {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += i;
                System.out.println("Callable_1");
            }
            return sum;
        };

        Callable callable2 = () -> {
            int sum = 0;
            for (int i = array.length / 2; i < array.length; i++) {
                sum = sum + array[i];
                System.out.println("Callable_2");
            }
            return sum;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList = Arrays.asList(callable1, callable2);
        List<Future<Integer>> results = executorService.invokeAll(taskList);

        int k = 0;
        int sum = 0;
        for (Future<Integer> result : results) {
            sum = sum + result.get();
            System.out.println("Sum of: " + ++k + " is: " + result.get());
        }
        System.out.println("Sum from the " + sum);
        System.out.println("Correct sum from intStream is: " + total);
        executorService.shutdown();
    }
}
