package com.lockedme;

import java.awt.Menu;
import java.awt.SystemTray;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	static final String projectFilesPath = "F:\\LockedMeFiles";
	static final String errorMessage1 = "Some Error has occured, please check the directory given.";
	static final String errorMessage2 = "If you face the same error again, Please contact: admin@lockeme.com";

	public static void displayMenu() {
		System.out.println("****************************************");
		System.out.println("\t\tWelcome to LockedMe.com");
		System.out.println("\t\tDeveloper Details: Sanjith Kumar V");
		System.out.println("****************************************");
		System.out.println("\t\t1. Display all the files");
		System.out.println("\t\t2. Add a New File");
		System.out.println("\t\t3. Delete a File");
		System.out.println("\t\t4. Search a File");
		System.out.println("\t\t5. Exit");
	}

	/**
	 * This method will return all the files in the directory
	 */

	public static void getAllFiles() {
//		using try-catch block
		try {
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length == 0) {
				System.out.println("Files are not present in the directory");
			} else {
				for (var l : listOfFiles) {
					System.out.println("File: " + l.getName());
				}
			}
		} catch (Exception ex) {
			System.out.println(errorMessage1);
			System.out.println(errorMessage2);
		}

	}

	public static void createFiles() {
		try {
			Scanner reader = new Scanner(System.in);
			String fileName;
			System.out.println("Enter File Name: ");
			fileName = reader.nextLine();
			int linesCount;
			System.out.println("Enter how many Lines into the file: ");
			linesCount = Integer.parseInt(reader.nextLine());

			FileWriter myWriter = new FileWriter(projectFilesPath + "//" + fileName);
			for (var i = 0; i <= linesCount; i++) {
				System.out.println("Enter the file line: ");
				myWriter.write(reader.nextLine() + "\n");
			}
			myWriter.close();
			reader.close();
			System.out.println("File Successfully Created.");
		} catch (Exception Ex) {
			System.out.println(errorMessage1);

		}
	}

	/**
	 * This method will delete the files to be deleted in the directory
	 */
	public static void deletefiles() {
		Scanner objScanner = new Scanner(System.in);
//		using try-catch block 
		try {
			String fileName;
//		Creating a Scanner Class 

			System.out.println("Enter the file name to be deleted: ");
			fileName = objScanner.nextLine();
			File file = new File(projectFilesPath + "//" + fileName);
			if (file.exists()) {
				file.delete();
				System.out.println("File deleted successfully: " + fileName);
			} else {
				System.out.println("File is not present in the directory");
			}
		} catch (Exception Ex) {
			System.out.println(errorMessage1);
		} finally {
//			Closing the Scanner Class
			objScanner.close();
		}
	}

	/**
	 * This method will search for files in the directory
	 */

	public static void searchFiles() {
		Scanner objScanner = new Scanner(System.in);
//		using try-catch block 
		try {
			String fileName;
//		Creating a Scanner Class 

			System.out.println("Enter the file name to be searched: ");
			fileName = objScanner.nextLine();
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			LinkedList<String> filenames = new LinkedList<String>();
			for (var l : listOfFiles) {
				filenames.add(l.getName());
			}
			if (filenames.contains(fileName)) {
				System.out.println("File is Available");
			} else {
				System.out.println("File not available");
			}

		} catch (Exception Ex) {
			System.out.println(errorMessage1);
		} finally {
//			Closing the Scanner class
			objScanner.close();
		}

	}

	public static void main(String[] args) {
		Scanner readScanner = new Scanner(System.in);
		int choice;
		do {
			displayMenu();
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(readScanner.nextLine());
//			Using Switch Case 
			switch(choice) {
				case 1:getAllFiles();
				break;
				case 2:createFiles();
				break;
				case 3:deletefiles();
				break;
				case 4:searchFiles();
				break;
				case 5:System.exit(0);
				break;
				default:
				System.out.println("Invalid Option entered");
				break;
			}
			
		} while (choice > 0);
		readScanner.close();
	}
}
