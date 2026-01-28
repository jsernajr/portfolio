public class WeatherData {
    private String date;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private String condition;

    public WeatherData(String date, double temperature, double humidity, double windSpeed, String condition) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
    }

    public String getDate() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return String.format("[%s] Temp: %.1f°C | Humidity: %.0f%% | Wind: %.1f km/h | %s",
                date, temperature, humidity, windSpeed, condition);
    }
}
