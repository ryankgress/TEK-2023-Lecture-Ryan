package com.tek.java.filestuffs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileExamples {

	public static void main(String[] args) {
//		File file = new File("C:\\Users\\ryank\\OneDrive - iup.edu\\Desktop\\TEK\\Development\\TEK-2023-Lecture\\ClassExamples\\src\\com\\tek\\java\\filestuffs\\readingFile.txt");
		File testFile = new File("C:/Users/ryank/OneDrive - iup.edu/Desktop/TEK/Development/TEK-2023-Lecture/ClassExamples/src/com/tek/java/filestuffs/readingFile.txt");
		File code = new File("C:/Users/ryank/OneDrive - iup.edu/Desktop/TEK/Development/TEK-2023-Lecture/ClassExamples/src/com/tek/java/filestuffs/FileExamples.java");

		File dir = new File("C:\\Users\\ryank\\OneDrive - iup.edu\\Desktop\\TEK\\Development\\TEK-2023-Lecture\\ClassExamples\\src\\com\\tek\\java\\filestuffs");
		Scanner inFile=null;
		
		try {
//			inFile = new Scanner(file);											// Use Scanner for reading
			BufferedReader br = new BufferedReader(new FileReader(testFile));	// Use BufferedReader for reading
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Reading with Scanner
//		while(inFile.hasNext()) {
//			System.out.println(inFile.nextLine());
//		}
//	
//		System.out.println();
//		System.out.println(dir.getAbsolutePath());
//
//		if(dir.isDirectory()) {
//			System.out.println(dir.getName() + " is a directory.");
//			
//			for(File f : dir.listFiles()) {
//				System.out.println(f.getName());
//			}
//		}
//		inFile.close();
	}

}
