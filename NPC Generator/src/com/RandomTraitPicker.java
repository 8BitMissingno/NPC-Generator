package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import enums.Traits;

public class RandomTraitPicker 
{
	/**
	 * Random number generator.
	 */
	private Random rng;
	/**
	 * Files to randomly pick traits from.
	 */
	private File[] traitFiles;
	/**
	 * The length in lines of each file in the traitFiles array.
	 */
	private int[] fileLengths;
	
	
	public RandomTraitPicker(String[] filePaths)
	{
		rng = new Random();
		traitFiles = new File[Traits.values().length];
		fileLengths = new int[Traits.values().length];
		
		createFiles(filePaths);
		countFileLengths();
	}
	
	
	/**
	 * Loads each file path into the files array.
	 * @param filePaths Array of file paths.
	 */
	private void createFiles(String[] filePaths)
	{
		for (int i = 0; i < filePaths.length; i++)
		{
			traitFiles[i] = new File(filePaths[i]);
		}
	}
	
	
	/**
	 * Reads through each file in traitFiles and stores the number of lines in them in 
	 * the fileLengths array.
	 */
	private void countFileLengths()
	{
		BufferedReader reader;
		int length;
		for (int file_i = 0; file_i < traitFiles.length; file_i++)
		{
			reader = makeBufferedReader(file_i);
			length = 0;
			try 
			{
				while (reader.ready())
				{
					reader.readLine();
					length++;
				}
				fileLengths[file_i] = length;
			} 
			catch (IOException e) 
			{
				System.err.println(
						"An error occured while reading file " + file_i + ".");
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Returns the number of lines in the file corresponding to the given ID.
	 * @param fileID Which file to count lines of.
	 * @return Number of lines in the file.
	 */
	private int getFileLength(int fileID)
	{
		return fileLengths[fileID];
	}
	
	
	/**
	 * Grabs a file from INFO_FILES and returns it as a BufferedReader.
	 * @param fileID File to be converted.
	 * @return The file as a BufferedReader.
	 */
	private BufferedReader makeBufferedReader(int fileID)
	{
		BufferedReader reader = null;
		try 
		{
			reader = new BufferedReader(new FileReader(traitFiles[fileID]));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("File " + fileID + " could not be found.");
			e.printStackTrace();
		}
		return reader;
	}
	
	
	/**
	 * Returns a random trait from a given file as a String.
	 * @param fileID File to pick a trait from.
	 * @return String containing trait.
	 */
	public String getRandomTrait(int fileID)
	{
		String trait = null;
		BufferedReader reader = makeBufferedReader(fileID);
		
		// Randomly select line to grab from file, add 1 to make range from 1 to file 
		// length.
		int targetLine = rng.nextInt(getFileLength(fileID)) + 1;
		
		// Find the selected line.
		for (int line = 0; line < targetLine; line++)
		{
			try 
			{
				trait = reader.readLine();
			} 
			catch (IOException e) 
			{
				System.err.println(
						"An error occured while reading file " + fileID + ".");
				e.printStackTrace();
			}
		}
		return trait;
	}
}
