import java.util.ArrayList;
import java.util.List;

//WeatherStation class that implements the Subject interface.
//This is the class that manages the observers (subscribers)
//and notifies them when the temperature changes

public class WeatherStation implements Subject {
    // List to store all the observers that are subscribed to the WeatherStation
    private final List<Observer> observers;
    private float temperature;

    //    Initializes the observers list (empty at the start)
    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

    public void setTemperature(float temperature) {

    }
}
