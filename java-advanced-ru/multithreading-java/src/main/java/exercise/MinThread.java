package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    public int[] numbers;
    public int minValue;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        setMinValue(Arrays.stream(numbers).min().getAsInt());
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int maxValue) {
        this.minValue = maxValue;
    }
}
// END
