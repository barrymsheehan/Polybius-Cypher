package com.barrysheehan.www;
import java.util.Scanner;

public class Menu {
	private Scanner userInput;
	private Cypher polybius;
	private FileHandler fileHandler;
	private boolean keepRunning = true;
	private Timer timer;
	
	public void start() {
		userInput = new Scanner(System.in);
		polybius = new Cypher();
		fileHandler = new FileHandler();
		timer = new Timer();
		
		
		/*
		 * Print title of program
		 */
		System.out.println("################################################################################\n");
		System.out.println("\t\t#        Polybius Cypher V1.0        #\n");
		System.out.println("################################################################################\n");
		
		while(keepRunning) {
			showMenu();
			int selection = 0;
			
			/*
			 * NumberFormatException was thrown by code in the try block below if something other than an int
			 * was entered by the user when the menu was displayed.
			 * try-catch block catches NumberFormatException and prompts user that input must be an integer.
			 */
			try {
				selection = Integer.parseInt(userInput.next());
			} catch(NumberFormatException nfe) {
				System.out.println("\n> !ERROR: Your selection must be an integer.");
			}
			
			userInput.nextLine(); // Ensures that \n newline character in the Scanner buffer is consumed after user enters an integer
			
			if(selection == 1) { // Set key
				menuSetKey();
			} else if(selection == 2) { // Encrypt text
				menuEncrypt();
			} else if(selection == 3) { // Decrypt text
				menuDecrypt();
			} else if(selection == 4) { // Encrypt text file
				menuEncryptTextFile();
			} else if(selection == 5) { // Decrypt text file
				menuDecryptTextFile();
			} else if (selection == 6) { // Quit
				keepRunning = false;
				System.out.println("Goodbye.\n");
				System.out.println("################################################################################");
				System.out.println("################################################################################");
			} else {
				System.out.println("> Invalid selection.\n");
			}
		}
		
	}
	
	/*
	 * showMenu()
	 */
	public void showMenu() {
		System.out.println("1.) Set New Keyword");
		System.out.println("2.) Encrypt Text (Manual Entry)");
		System.out.println("3.) Decrypt Text (Manual Entry)");
		System.out.println("4.) Encrypt Text File");
		System.out.println("5.) Decrypt Text File");
		System.out.println("6.) Quit");
		System.out.println("\nMake Selection now [1 - 6] >");
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	/*
	 * menuSetKey()
	 */
	private void menuSetKey() {
		System.out.println("\n> Please enter keyword: (Key must contain only letters (A-Z or a-z), and/or numbers (0-9). Key can not be blank.)");
		String key = userInput.nextLine(); // Using nextLine rather than next makes sure spaces are accepted as part of input
		if(polybius.setKey(key)) {
			System.out.println("\n> New key " + polybius.getKey() + " has been set.\n");
		} else {
			System.out.println("\n> !ERROR: Invalid key. New key has not been set.");
			System.out.println("> Key must contain only letters (A-Z or a-z), and/or numbers (0-9).)\n");
		};
	}
	
	/*
	 * menuEncrypt()
	 */
	private void menuEncrypt() {
		if(polybius.getKey() != null) { // Ensure a key has been set
			System.out.println("\n> Please enter text to be encrypted:");
			String plainText = userInput.nextLine();
			
			timer.start();
			String encryptedText = polybius.encrypt(plainText);
			timer.stop();
			
			System.out.println("\n> Text encrypted successfully:");
			System.out.println("> " + encryptedText + "\n");
			System.out.println("> Text encrypted in " + timer.calculateTime() + " milliseconds.\n");
		} else {
			System.out.println("\n> No key currently set. Please set a key before attempting to encrypt or decrypt text.\n");
		}
	}
	
	/*
	 * menuDecrypt()
	 */
	private void menuDecrypt() {
		if(polybius.getKey() != null) { // Ensure a key has been set
			System.out.println("\n> Please enter text to be decrypted:");
			String encryptedText = userInput.nextLine();
			
			if(polybius.decrypt(encryptedText) != null) {
				
				timer.start();
				String decryptedText = polybius.decrypt(encryptedText);
				timer.stop();
				
				System.out.println("\n> Text decrypted successfully:");
				System.out.println("> " + decryptedText + "\n");
				System.out.println("> Text decrypted in " + timer.calculateTime() + " milliseconds.\n");
			} else {
				System.out.println("> Text is corrupt and can not be decrypted.\n");
			}
			
		} else {
			System.out.println("\n> No key currently set. Please set a key before attempting to encrypt or decrypt text.\n");
		}
	}
	
	/*
	 * menuEncryptTextFile()
	 */
	private void menuEncryptTextFile() {
		if(polybius.getKey() != null) { // Ensure a key has been set
			System.out.println("\n> Please enter path to file to be encrypted:");
			String inputFileText = fileHandler.readTextFile(userInput.nextLine());
			
			if(inputFileText == null) {
				System.out.println("> Can not proceed with encryption without valid input file.\n");
				return;
			}
			
			System.out.println("\n> Please enter path at which to save new encrypted file:");
			String outputFilePath = userInput.nextLine();
			
			timer.start();
			String encryptedText = polybius.encrypt(inputFileText);
			boolean writeFile = fileHandler.writeTextFile(encryptedText, outputFilePath);
			timer.stop();
			
			if(inputFileText != null && writeFile == true ) {
				System.out.println("> File encrypted successfully.");
				System.out.println("> File encrypted in " + timer.calculateTime() + " milliseconds.\n");
			} else {
				System.out.println("\n> Unable to encrypt file.\n");
			}
		} else {
			System.out.println("\n> No key currently set. Please set a key before attempting to encrypt or decrypt text.\n");
		}
		
	}
	
	/*
	 * menuDecryptTextFile()
	 */
	private void menuDecryptTextFile() {
		if(polybius.getKey() != null) { // Ensure a key has been set
			System.out.println("\n> Please enter path to file to be decrypted:");
			String inputFileText = fileHandler.readTextFile(userInput.nextLine());
			
			if(inputFileText == null) {
				System.out.println("> Can not proceed with decryption without valid input file.\n");
				return;
			}
			
			System.out.println("\n> Please enter path at which to save new decrypted file:");
			String outputFilePath = userInput.nextLine();
			
			timer.start();
			String decryptedText = polybius.decrypt(inputFileText);
			timer.stop();
			
			if(fileHandler.writeTextFile(decryptedText, outputFilePath)) {
				System.out.println("> File decrypted successfully.");
				System.out.println("> File decrypted in " + timer.calculateTime() + " milliseconds.\n");
			} else {
				System.out.println("\n> Unable to decrypt file.\n");
			}
			
		} else {
			System.out.println("\n> No key currently set. Please set a key before attempting to encrypt or decrypt text.\n");
		}
	}
}
