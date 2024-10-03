# Observer Pattern exercise - Java Weather Station
In this exercise, you will implement a weather station that tracks temperature changes. Several devices, such as a display and a warning system, will subscribe to the weather station, receive updates when the temperature changes, and display the information to the user.

Clone this repo with some sample codes for IntelliJ Idea. Or you can create a new project from scratch.

## 1. Create the `Observer` Interface
The `Observer` interface will have a method `update()` that observers need to implement (using `@Override`) to get notified of temperature changes.

```java
public interface Observer {
    void update(float temperature);
}
```

## 2. Create the `Subject` Interface
The `Subject` interface will have methods to add and remove observers, as well as a method to notify all observers about the latest data.

```java
import java.util.List;
import java.util.ArrayList;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

## 3. Create the `WeatherStation` class, our subject to observe
This class will implement the `Subject` interface. It stores a list of observers and notifies them whenever there is a change in temperature.

```java
public class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
```

## 4. Create the `Display` class, our first observer
This observer will display the current temperature whenever it gets updated.
```java
public class Display implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Your text of choice");
    }
}
```

## 5. Create the `WarningSystem` class, our second observer
This observer will print a warning if the temperature is too high, or too low, your choice.
### Step 5: Create the `WarningSystem` class (Observer)
This observer will print a warning message if the temperature exceeds a certain threshold.

```java
public class WarningSystem implements Observer {
    @Override
    public void update(float temperature) {
        // Go wild
    }
}
```

## 6. Write `Main` to test our work
In the `Main` class, create a `WeatherStation`, our 2 observers, and make some temp changes. The output should show the latest temps, and warnings when needed.

```java
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Display display = new Display();
        WarningSystem warningSystem = new WarningSystem();

        weatherStation.addObserver(display);
        weatherStation.addObserver(warningSystem);

        weatherStation.setTemperature(20);
        weatherStation.setTemperature(35);
        weatherStation.setTemperature(-25);
    }
}
```

## 7. Bonus tasks for the Java lovers
* Create another observer, called "Logger". This device save temp changes to a file.
* Modify `Subject` and `Observer` to include weather conditions also
