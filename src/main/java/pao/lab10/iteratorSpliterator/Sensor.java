package pao.lab10.iteratorSpliterator;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class Sensor {
    public double getTemperature() {
        // Generate a random temperature between 0 and 100 degrees Celsius
        return ThreadLocalRandom.current().nextDouble(0, 100);
    }
}

class WeatherMonitor {
    private final Spliterator<Double> temperatureSpliterator;
    private final AtomicBoolean isMonitoring;

    public WeatherMonitor(Spliterator<Double> temperatureSpliterator) {
        this.temperatureSpliterator = temperatureSpliterator;
        this.isMonitoring = new AtomicBoolean(true);
    }

    public void startMonitoring() {
        Thread thread = new Thread(() -> {
            while (isMonitoring.get()) {
                if (temperatureSpliterator.tryAdvance(temp -> System.out.println("Temperature: " + temp))) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        thread.start();
    }

    public void stopMonitoring() {
        isMonitoring.set(false);
    }
}

class SensorSpliterator extends Spliterators.AbstractSpliterator<Double> {
    private final Sensor sensor;

    public SensorSpliterator(Sensor sensor) {
        super(Long.MAX_VALUE, Spliterator.NONNULL | Spliterator.IMMUTABLE);
        this.sensor = sensor;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Double> action) {
        // Generate a temperature reading from the sensor and pass it to the action
        action.accept(sensor.getTemperature());
        return true;
    }

    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        SensorSpliterator spliterator = new SensorSpliterator(sensor);
        WeatherMonitor monitor = new WeatherMonitor(spliterator);
        monitor.startMonitoring();
        // Sleep for some time before stopping the monitoring
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor.stopMonitoring();
    }
}

