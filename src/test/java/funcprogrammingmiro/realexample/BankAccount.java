package funcprogrammingmiro.realexample;

import lombok.*;
import org.testng.annotations.NoInjection;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
    @NonNull
    private int id;
    @NonNull
    double balance;
    @NonNull
    private String accountName;
    final Lock lock = new ReentrantLock();

    BiFunction<Double, Double, Double> subtractFunction = (a, b) -> a - b;
    BiFunction<Double, Double, Double> addFunction = (a, b) -> a + b;

    public boolean withdraw (double amount) throws InterruptedException {
        if(this.lock.tryLock()){
            Thread.sleep(100);
            balance = subtractFunction.apply(balance, amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }

    public boolean deposit (double amount) throws InterruptedException {
        if(this.lock.tryLock()){
            Thread.sleep(100);
            balance= addFunction.apply(balance,amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }


    public boolean transfer (BankAccount to, double amount) throws InterruptedException {
        if(withdraw(amount)){
            System.out.println("Withdrawing amount: " + amount + " from: " + getAccountName());
            if(to.deposit(amount)){
                System.out.println("Depositing amount:" + amount + " to: " + to.getAccountName());
                return true;
            }else{
                System.out.println("Failed to acquire both locks: refunding " + amount + " to: " + accountName);
                while (!deposit(amount))
                    continue;
            }
        }
        return false;
    }
}