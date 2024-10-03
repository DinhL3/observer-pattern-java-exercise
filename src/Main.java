public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Display display = new Display();
        WarningSystem warningSystem = new WarningSystem();

        weatherStation.addObserver(display);
        weatherStation.addObserver(warningSystem);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(35);

//
    }
}
