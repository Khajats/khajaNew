package ajith;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class WetherReports {

	public static void main(String[] args) throws IOException {
		Response response = RestAssured.given().get(
				"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");
		if (response.statusCode() == 200) {
			// Parse the JSON response using Jackson ObjectMapper
			ObjectMapper objectMapper = new ObjectMapper();
			WeatherData weatherData = objectMapper.readValue(response.asString(), WeatherData.class);

			// Access the WeatherEntry data
			for (WeatherEntry weatherEntry : weatherData.getList()) {
				// You can now work with the WeatherEntry objects here
				System.out.println("Date/Time: " + weatherEntry.getDt_txt());
				System.out.println("Temperature: " + weatherEntry.getMain().getTemp());
				System.out.println("Weather Description: " + weatherEntry.getWeather().get(0).getDescription());
				System.out.println("Clouds Percentage: " + weatherEntry.getClouds().getAll());
				System.out.println("Wind Speed: " + weatherEntry.getWind().getSpeed());
				System.out.println("------------------------------");
			}
		} else {
			System.out.println("Failed to fetch weather data. Status code: " + response.statusCode());
		}
	}

	@Test
	public static void test1() throws JsonProcessingException {
		List<WeatherEntry> object = RestAssured.given().get(
				"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
				.jsonPath().getObject("list", new TypeRef<List<WeatherEntry>>() {
				});

		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object.get(0));
		System.out.println(writeValueAsString);

	}

	@Test
	public static void test2() throws JsonProcessingException {
		WeatherData data = RestAssured.given().get(
				"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
				.as(WeatherData.class);
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(writeValueAsString);

	}

	@Test
	public static void test3() throws IOException {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Menu:");
			System.out.println("1. Get Temperature");
			System.out.println("2. Get Wind Speed");
			System.out.println("3. Get Pressure");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				getTemperature();
				break;
			case 2:
				getWindSpeed();
				break;
			case 3:
				getPressure();
				break;
			case 0:
				System.out.println("Exiting the program.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 0);
	}

	private static void getTemperature() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date: ");
		String date = scanner.nextLine();
		WeatherData data = RestAssured.given().get(
				"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
				.as(WeatherData.class);


		System.out.println("Temperature data for " + date);

	}

	private static void getWindSpeed() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date: ");
		String date = scanner.nextLine();



		System.out.println("Wind speed data for " + date);

	}

	private static void getPressure() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date: ");
		String date = scanner.nextLine();


		System.out.println("Pressure data for " + date);


	}
}
