package com.barrysheehan.www;
import java.io.*;

/*
 * FileHandler reads files to be processed by the program and writes files to disk
 */

public class FileHandler {
	
	/*
	 * readTextFile reads from a text file and stores the contents of the text file in a StringBuilder object
	 * Takes the full path of a text file in the form of a String as an argument
	 * The text in the StringBuilder object is returned as a String
	 */
	public String readTextFile(String filePath) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
				StringBuilder sb = new StringBuilder(); // StringBuilder to store contents of text file
				
				String next;
				while((next = br.readLine()) != null) { // Because of BufferedReader we can read line by line. Null at EOF.
					sb.append(next);
		        }
				br.close();
				return sb.toString();
				
			} catch(FileNotFoundException fnfe) {
				System.out.println("\n> !ERORR: Specified file " + filePath + " not found.");
				return null; // return null if an Exception occurs
			} catch(IOException ioe) {
				System.out.println("\n> !ERROR: IO Exception occurred.");
				return null;
			} catch(Exception e) {
				System.out.println("\n> !ERROR: Something went wrong.");
				return null;
			}
	}
	
	
	/*
	 * writeTextFile creates a new file and then writes the contents of the supplied String to it
	 * It takes the contents of the newly created file as its first argument in the form of a String
	 * It takes the full path of a new file to create as its second argument in the form of a String
	 */
	public boolean writeTextFile(String fileContents, String outputFilePath) {
		try {
			File f = new File(outputFilePath); // Explicitly create file so that its absolute path can be returned later
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath));
			bw.write(fileContents);
			bw.flush();
			bw.close();
			
			System.out.println("\n> File saved at " + f.getAbsolutePath()); // Inform user new file has been written & its location
			return true; // Return true if new file created
		} catch(IOException ioe) {
			System.out.println("\n> !ERROR: IO Exception occurred."); // Print error message to user
			return false; // Return false if IOException is encountered
		}
	}
}
