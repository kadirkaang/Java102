import java.util.List;

public class NumberProcessor implements Runnable{
    private final List<Integer> numbers;
    private final List<Integer> oddNumbers;
    private final List<Integer> evenNumbers;

    public NumberProcessor(List<Integer> numbers, List<Integer> oddNumbers, List<Integer> evenNumbers) {
        this.numbers = numbers;
        this.oddNumbers = oddNumbers;
        this.evenNumbers = evenNumbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 2 == 1) {
                synchronized (oddNumbers) {
                    oddNumbers.add(number);
                }
            } else {
                synchronized (evenNumbers) {
                    evenNumbers.add(number);
                }
            }
        }
    }
}
