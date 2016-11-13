
package week3;

public class TemperatureConversionFormulae 
{

	double input;
	double result;

	//convert celcius to celcius
	public static double CelciustoCelcius(double input)
	{
		double result;
		result = input;
		return Double.parseDouble(String.format(" %.2f", result));
	}
	
	//convert celcius to fahrenheit
	public static double CelciustoFahrenheit(double input)
	{
		double result;
		result = (input * (9.0f / 5.0f)) + 32.0;	
		return Double.parseDouble(String.format(" %.2f", result));
	}

	//convert celcius to kelvin
	public static double CelciustoKelvin(double input)
	{
		double result;
		result = input + 273.15;
		return Double.parseDouble(String.format(" %.2f", result));
	}

	//convert fahrenheit to celcius
	public static double FahrenheittoCelcius(double input)
	{
		double result;
		result =  (input - 32) * (5.0f / 9.0f);
		return Double.parseDouble(String.format(" %.2f", result));
	}

	//convert fahrenheit to fahrenheit
	public static double FahrenheittoFahrenheit(double input)
	{
		double result;
		result = input;
		return Double.parseDouble(String.format(" %.2f", result));
	}

	//convert fahrenheit to kelvin
	public static double FahrenheittoKelvin(double input)
	{
		double result;
		result = (input + 459.67) * (5.0f/ 9.0f);
		return Double.parseDouble(String.format(" %.2f", result));
	}

	//convert kelvin to celcius
	public static double KelvintoCelcius(double input)
	{
		double result;
		result = (input - 273.15);
		return Double.parseDouble(String.format(" %.2f", result));
	}

	//convert kelvin to fahrenheit
	public static double KelvintoFahrenheit(double input)
	{
		double result;
		result = (input * (9.0f / 5.0f) - 459.67);
		return Double.parseDouble(String.format(" %.2f", result));
	}

	//convert kelvin to kelvin
	public static double KelvintoKelvin(double input)
	{
		double result;
		result = input;
		return Double.parseDouble(String.format(" %.2f", result));
	}
}

