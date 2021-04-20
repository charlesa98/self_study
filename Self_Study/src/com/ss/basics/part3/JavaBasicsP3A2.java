package com.ss.basics.part3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JavaBasicsP3A2 {

	/**
	 * This program will append text to an existing Java file
	 * takes in files from the command line to edit. Only handles 1 file
	 */
	public static void main(String[] args){
		String text = " !!This is the new appended text!!";		//simple message
		//try to open the file and throw exception if not found
		try {
			File f = new File(args[0]);								//file is the first argument in the command line 
			FileWriter newFile = new FileWriter(f, true);			//true means to append the data
			BufferedWriter buff = new BufferedWriter(newFile);		//create a buffer with the same data as the original file
			
			buff.write(text);										//append the text
			buff.close();											//make sure to close the file
			System.out.println("All done");
		}
		catch (IOException e)
		{
			System.out.println("File not found");
		}
	}
}
