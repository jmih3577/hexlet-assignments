package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> map = new HashMap<>();
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);
        // Запускаем поток при помощи метода start()
        // После этого начинает выполняться метод run() потока
        maxThread.start();
        minThread.start();
        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
        map.put("min", minThread.getMinValue());
        map.put("max", maxThread.getMaxValue());
        return map;
    }
    // END
}
