package funcprogrammingmiro.realexample;

import com.dydko.funcprogramming.realexample.AccountFactory;
import com.dydko.funcprogramming.realexample.BankAccount;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BankTransfer1 {
    AccountFactory accountFactory = BankAccount::new;
    com.dydko.funcprogramming.realexample.BankAccount studentBankAccount = accountFactory.getBankAccount(1, 50000, "StudentA");
    com.dydko.funcprogramming.realexample.BankAccount universityBankAccount = accountFactory.getBankAccount(2, 100000, "University");

    BiPredicate<Double, Double> p1 = (balance, amount) -> balance > amount;
    BiConsumer<String, Double> printer = (x, y) -> System.out.println(x + y);
    BiConsumer<com.dydko.funcprogramming.realexample.BankAccount, BankAccount> printer2 = (student, university) ->
            System.out.println("Ending balance of student account: " + studentBankAccount.getBalance() +
                    " University account: " + universityBankAccount.getBalance());

    ExecutorService service = Executors.newFixedThreadPool(10);

    @Test
    public void test1() { Thread t1 = new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + " says :: Executing Transfer");
        try {
            double amount = 1000;
            if (!p1.test(studentBankAccount.getBalance(), amount)) {
                printer.accept(Thread.currentThread().getName() + "says :: balance insufficient, ", amount);
                return;
            }
            while (!studentBankAccount.transfer(universityBankAccount, amount)) {
                TimeUnit.MILLISECONDS.sleep(100);
                continue;
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        printer.accept(Thread.currentThread().getName() + " says transfer is successful: Balance in account ",
                universityBankAccount.getBalance());
    });

        for(
                int i = 0;
                i< 20;i++)

        {
            service.submit(t1);
        }
        service.shutdown();

        try

        {
            while (!service.awaitTermination(24L, TimeUnit.HOURS)) {
                System.out.println("Not Yet. Still waiting for termination");
            }
        } catch(
                InterruptedException iee)

        {
            iee.printStackTrace();
        }
        printer2.accept(studentBankAccount,universityBankAccount);
    }
}
