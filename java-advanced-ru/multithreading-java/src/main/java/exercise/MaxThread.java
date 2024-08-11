package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread{
    public int[] numbers;
    public int maxValue;
    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public void run() {
        setMaxValue(Arrays.stream(numbers).max().getAsInt());
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
// END
