package br.edu.ifpb.mt.tt.temperature;

/**
 * Referências: 
 * <pre>
 *  1) https://github.com/tomekkaczanowski/junit-put-exercises/blob/master/src/main/java/com/practicalunittesting/chp03/FahrenheitCelciusConverter.java
 *  2) http://en.wikipedia.org/wiki/Conversion_of_units_of_temperature
 * </pre>
 * 
 * @author jaindsonvs
 *
 */
public class TemperatureConverter {

	public double fahrenheitToCelcius(double fahrenheit) {
		return (fahrenheit - 32) * 5.0 / 9.0;
	}

	public double fahrenheitToKelvin(double fahrenheit) {
		return celciusToKelvin(fahrenheitToCelcius(fahrenheit));
	}

	public double celciusToFahrenheit(double celcius) {
		return celcius * 9.0 / 5.0 + 32.0;
	}
	
	public double celciusToKelvin(double celcius) {
		return celcius + 273.15;
	}

	public double kelvinToCelcius(double kelvin) {
		return kelvin - 273.15;
	}

	public double kelvinToFahrenheit(double kelvin) {
		return celciusToFahrenheit(kelvinToCelcius(kelvin));
	}
	
}
