package lambdamiro;

import org.testng.annotations.Test;

public class RunnableExample {
    @Test
    public void runnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                System.out.println("Traditional: " + sum);
            }
        };
        new Thread(runnable).start();

        Runnable runnable1 = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("Run lambda: " + sum);
        };
        new Thread(runnable1).start();

        new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            System.out.println("Thread run lambda: " + sum);
        }).start();
    }
}
