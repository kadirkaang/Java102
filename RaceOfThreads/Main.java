import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int startIndex = i * 2500;
            int endIndex = startIndex + 2500;
            List<Integer> sublist = numbers.subList(startIndex, endIndex);
            Thread t = new Thread(new NumberProcessor(sublist, oddNumbers, evenNumbers));
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Even numbers : " + evenNumbers);
        System.out.println("Odd numbers : " + oddNumbers);
    }
}