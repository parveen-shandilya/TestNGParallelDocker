package CommonMethods;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class CheckDownloadedFile {

	public static String isFileDownloaded(String fileName) {
		String home = System.getProperty("user.home");
		String downloadsFolder = null;
		String fileFound = "";
		int maxRetries = 5; // Check up to 5 times (adjust as needed)
		int waitTimeSeconds = 5; // Wait 10 seconds before checking again

		// Determine the Downloads folder based on OS
		if (System.getProperty("os.name").contains("Windows")) {
			downloadsFolder = home + "\\Downloads\\";
		} else if (System.getProperty("os.name").contains("Linux")) {
			// downloadsFolder = home + "/Downloads/";
			downloadsFolder = "/home/jenkins";

		}
    

		String filePattern = Pattern.quote(fileName) + "(\\(\\d+\\))?.*";

		// Get the Downloads folder as a File object
		File folder = new File(downloadsFolder);

		if (!folder.exists() || !folder.isDirectory()) {
			System.out.println("Downloads folder does not exist.");

		}

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			// List all files in the Downloads folder that match the file pattern
			File[] matchingFiles = folder.listFiles((dir, name) -> Pattern.matches(filePattern, name));

			if (matchingFiles != null && matchingFiles.length > 0) {
				System.out.println("File is present in the Downloads folder.");
				fileFound = "File Present";
				return fileFound;
			} else {
				System.out.println("File not found. Retrying (" + attempt + "/" + maxRetries + ")...");
				try {
					TimeUnit.SECONDS.sleep(waitTimeSeconds); // Wait before retrying
				} catch (InterruptedException e) {
					System.out.println("Thread interrupted.");
					Thread.currentThread().interrupt();
				}
			}
		}
		return fileFound;
		
	}
	
	
	
	
	
	
	
	public static String isFileDownloaded(String fileName,File directory) {
		String fileFound = "";
		
		File[] files = directory.listFiles();
        boolean isFileDownloaded = files != null && files.length > 0;

        if (isFileDownloaded) {
            System.out.println("File downloaded successfully: " + files[0].getName());
            fileFound = "File Present";
            // Assert file exists
            assert files[0].exists();

            // Delete the downloaded file
            if (files[0].delete()) {
                System.out.println("Downloaded file deleted successfully.");
            } else {
                System.out.println("Failed to delete the downloaded file.");
            }
        } else {
            System.out.println("File not downloaded.");
            fileFound = "File not Present";
        }

    
		return fileFound;
	}
	
	
	
	

}