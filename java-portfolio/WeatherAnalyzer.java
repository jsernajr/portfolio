import java.util.ArrayList;
import java.util.List;

public class WeatherAnalyzer {
    private List<WeatherData> weatherDataList;

    public WeatherAnalyzer() {
        this.weatherDataList = new ArrayList<>();
    }

    public void addData(WeatherData data) {
        weatherDataList.add(data);
    }

    public double getAverageTemperature() {
        if (weatherDataList.isEmpty()) return 0;
        double sum = 0;
        for (WeatherData data : weatherDataList) {
            sum += data.getTemperature();
        }
        return sum / weatherDataList.size();
    }

    public double getAverageHumidity() {
        if (weatherDataList.isEmpty()) return 0;
        double sum = 0;
        for (WeatherData data : weatherDataList) {
            sum += data.getHumidity();
        }
        return sum / weatherDataList.size();
    }

    public double getMaxTemperature() {
        if (weatherDataList.isEmpty()) return 0;
        double max = weatherDataList.get(0).getTemperature();
        for (WeatherData data : weatherDataList) {
            if (data.getTemperature() > max) {
                max = data.getTemperature();
            }
        }
        return max;
    }

    public double getMinTemperature() {
        if (weatherDataList.isEmpty()) return 0;
        double min = weatherDataList.get(0).getTemperature();
        for (WeatherData data : weatherDataList) {
            if (data.getTemperature() < min) {
                min = data.getTemperature();
            }
        }
        return min;
    }

    public double getMaxWindSpeed() {
        if (weatherDataList.isEmpty()) return 0;
        double max = weatherDataList.get(0).getWindSpeed();
        for (WeatherData data : weatherDataList) {
            if (data.getWindSpeed() > max) {
                max = data.getWindSpeed();
            }
        }
        return max;
    }

    public int getDataCount() {
        return weatherDataList.size();
    }

    public void displayAllData() {
        if (weatherDataList.isEmpty()) {
            System.out.println("No weather data available.");
            return;
        }
        System.out.println("\n--- Weather Data Records ---");
        for (WeatherData data : weatherDataList) {
            System.out.println(data);
        }
    }

    public void displayAnalysis() {
        System.out.println("\n🌡️ WEATHER ANALYSIS REPORT");
        System.out.println("============================");
        System.out.println("Data Points: " + getDataCount());
        System.out.println("Avg Temperature: " + String.format("%.1f°C", getAverageTemperature()));
        System.out.println("Max Temperature: " + String.format("%.1f°C", getMaxTemperature()));
        System.out.println("Min Temperature: " + String.format("%.1f°C", getMinTemperature()));
        System.out.println("Avg Humidity: " + String.format("%.0f%%", getAverageHumidity()));
        System.out.println("Max Wind Speed: " + String.format("%.1f km/h", getMaxWindSpeed()));
    }

    public static void main(String[] args) {
        WeatherAnalyzer analyzer = new WeatherAnalyzer();

        // Add sample weather data
        analyzer.addData(new WeatherData("2026-01-25", 22.5, 65, 12.3, "Sunny"));
        analyzer.addData(new WeatherData("2026-01-26", 20.1, 72, 15.8, "Cloudy"));
        analyzer.addData(new WeatherData("2026-01-27", 18.9, 85, 22.4, "Rainy"));
        analyzer.addData(new WeatherData("2026-01-28", 21.3, 68, 10.5, "Partly Cloudy"));
        analyzer.addData(new WeatherData("2026-01-29", 24.7, 58, 8.2, "Sunny"));

        analyzer.displayAllData();
        analyzer.displayAnalysis();
    }
}
