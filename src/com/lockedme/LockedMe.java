package com.lockedme;

import java.io.File;

public class LockedMe {
	static final String projectFilesPath = "F:\\LockedMeFiles";

	public static void displayMenu() {
		System.out.println("****************************************");
		System.out.println("\t\tWelcome to LockedMe.com");
		System.out.println("****************************************");
		System.out.println("\t\t1. Display all the files");
		System.out.println("\t\t2. Add a New File");
		System.out.println("\t\t3. Delete a File");
		System.out.println("\t\t4. Search a File");
		System.out.println("\t\t5. Exit");
	}

	public static void getAllFiles() {
		try {
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length == 0) {
				System.out.println("Files is not present in the directory");
			} else {
				for (var l : listOfFiles) {
					System.out.println("File: " + l.getName());
				}
			}
		} catch (Exception ex) {
			System.out.println("Some Error has occured, please check the directory given.");
			System.out.println("If you face the same error again, Please contact: admin@lockeme.com");
		}

	}

	public static void createFiles() {

	}

	public static void deletefiles() {

	}

	public static void searchFiles1() {

	}

	public static void main(String[] args) {
		getAllFiles();

	}
}
