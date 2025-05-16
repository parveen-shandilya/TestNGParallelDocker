package CommonMethods;

import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateAndTime {
	public static String date1;

	public DateAndTime(WebDriver driver) {
	}

	public static void dateTimeGenerator() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		date1 = dateFormat.format(date);
		System.out.println(date1);

	}

	// convert "MMMM d, yyyy" to "MM/dd/yyyy"
	public String dateFormatConverter(String inputDate){

		// Define the format for the input date
		//if(inputDate)
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

		// Define the format for the output date
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate ="";
		try {
			// Parse the input date string
			LocalDate date = LocalDate.parse(inputDate, inputFormatter);

			// Format the date to the desired output format
			formattedDate = date.format(outputFormatter);

			// Print the formatted date
			System.out.println("Formatted Date : " + formattedDate);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format...");
			e.printStackTrace();


		}
		return formattedDate ;
	}

	// convert "MMMM d, yyyy" to "MM/dd/yyyy"
	public String dateFormatConverter(String inputDate,String inputFormat,String outputFormat){

		// Define the format for the input date
		//if(inputDate)
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat);

		// Define the format for the output date
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat);
		String formattedDate ="";
		try {
			// Parse the input date string
			LocalDate date = LocalDate.parse(inputDate, inputFormatter);

			// Format the date to the desired output format
			formattedDate = date.format(outputFormatter);

			// Print the formatted date
			System.out.println("Formatted Date : " + formattedDate);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format...");
			e.printStackTrace();


		}
		return formattedDate ;
	}
	// update the date  by adding the days ...
	public String dateManuplation(String inputDate, int addDays){

		// Define the input and output date formats
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String formattedDate = "" ;
		try {
			// Parse the input date string
			LocalDate date = LocalDate.parse(inputDate, dateFormatter);

			// Add  days to the date
			LocalDate newDate = date.plusDays(addDays);

			// Format the new date back to the desired format
			formattedDate = newDate.format(dateFormatter);

			// Print the updated date
			System.out.println("Updated Date: " + formattedDate);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format.");
			e.printStackTrace();
		}
		return formattedDate;
	}

	public String extractDateFromString(String st) {
		//String input = "Created on September 01, 2024 by Comcate";

		String datePart ="";
		//  a regex pattern for dates in this format "Month Day, Year"
		String datePattern = "\\b([A-Z][a-z]+ \\d{1,2}, \\d{4})\\b";
		Pattern pattern = Pattern.compile(datePattern);
		Matcher matcher = pattern.matcher(st);

		// find and print all matching dates
		while (matcher.find()) {
			datePart = matcher.group(1);
			System.out.println("Extracted Date : " + datePart);
		}
		return datePart;
	}
	
	
	public static String getCurrentDate(String format) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        // Get the current date
        LocalDate currentDate = LocalDate.now();
		return currentDate.format(formatter);
		
	}
	
	
public static String getPreviosDate(String format,int daysBack) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

    // Get the current date
	 LocalDate currentDate = LocalDate.now();
	 LocalDate pastDate = currentDate.minusDays(daysBack);
	return pastDate.format(formatter);
		
	}


}