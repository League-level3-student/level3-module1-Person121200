package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton cityWeather;
	JButton cityCondition;
	JButton cityTemp;
	String cityInput;
	String cityConditionInput;
	String cityName;
	String minTemp;
	String maxTemp;
	WeatherData datum;

	public void setup() {
		frame = new JFrame("California Weather");
		panel = new JPanel();
		cityWeather = new JButton("Check Weather in a City");
		cityCondition = new JButton("Check All Cities With Weather Condition");
		cityTemp = new JButton("Enter Min and Max temperatures: ");
		cityCondition.addActionListener(this);
		cityWeather.addActionListener(this);
		cityTemp.addActionListener(this);
		frame.add(panel);
		panel.add(cityWeather);
		panel.add(cityCondition);
		panel.add(cityTemp);
		frame.setVisible(true);
		frame.pack();

	}

	void start() {
		setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
		if (cityWeather == e.getSource()) {
			cityInput = JOptionPane.showInputDialog("Please enter a city to check the weather: ");
			cityName = Utilities.capitalizeWords(cityInput);
			datum = weatherData.get(cityName);

			if (datum == null) {
				System.out.println("Unable to find weather data for: " + cityName);
			} else {
				System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of "
						+ datum.temperatureF + " F");
			}
		}
		if (cityCondition == e.getSource()) {

			cityConditionInput = JOptionPane.showInputDialog("Please Enter City Weather Condition: ");
			for (String city : weatherData.keySet()) {
				if (cityConditionInput.equals(weatherData.get(city).weatherSummary) ) {
					System.out.println(city);
				}

			}
		}
		if(cityTemp == e.getSource()) {
			minTemp = JOptionPane.showInputDialog("Enter Minimum Temperature: ");
			maxTemp = JOptionPane.showInputDialog("Enter Maximum Temperature");
			double minTempInt = Double.parseDouble(minTemp);
			double maxTempInt = Double.parseDouble(maxTemp);
			for(String city : weatherData.keySet()) {
				if(weatherData.get(city).temperatureF >= minTempInt && weatherData.get(city).temperatureF <= maxTempInt) {
					System.out.println(city);
				}
			}
		}
	}
}
