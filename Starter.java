package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Starter {

	public static void main(String[] args) {

		FileReader reader;
		File tobeRead = null;
		// Get the path to the directory containing the Jar file being run
		String dirPath = System.getProperty("user.dir");
		// Specify the extension of the file you want to check for
		String extension = ".goku";
		// Create a File object for the directory
		File dir = new File(dirPath);
		// Get an array of File objects for all the files in the directory
		File[] files = dir.listFiles();
		// Loop through the array of files and check if any have the specified extension
		if (files != null)
			for (File file : files) {
				if (file.isFile() && file.getName().endsWith(extension)) {
					tobeRead = file;
//					System.out.println("Found a file with the extension " + extension + ": " + file.getName());
				}
			}
		try {
			reader = new FileReader(tobeRead);
			int character;
			String text = "";
			while ((character = reader.read()) != -1) {
				if (character != 13 && character != 10) {
					text = text + ((char) character);
				}
			}
			new Compiler(text,dirPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}