/**
* Reads in a file word-by-word counting and outputting how many of each word exists in the selected file.
* @author Elliot Rhodes
* @version 9/5/2013
**/
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.*;

public class ReadFile
{
	HashMap<String, Integer> words = new HashMap<String, Integer>();
	ArrayList<String> FileWords = new ArrayList<String>();
	public void readIt(Scanner inFile)
	{

		while (inFile.hasNext())
		{
			String word = inFile.next();
			word = word.toLowerCase();
			word = word.replaceAll("([a-z]+)[?:!.,;]*", "$1");
			FileWords.add(word);
		}
	}

	public static void main(String [] args)
	{
		if (args.length < 1)
		{
			System.out.println("Please select a file containing at least one word.");
		}
		else
		{
			File fileToRead = new File(args[0]);
			try
			{
				Scanner in = new Scanner(fileToRead);
				ReadFile mainObject = new ReadFile();
				mainObject.readIt(in);
				mainObject.wordCount();
				mainObject.showWordCount();
			}
			catch(IOException e)
			{
				System.out.println("There was a file error " + e);
			}
		}
	}

	public void wordCount()
	{
		for(String word : FileWords)
		{
			Integer counter = words.get(word);
			if(counter == null)
			{
				counter = 0;
			}
			words.put(word, counter + 1);
		}
	}

	public void showWordCount()
	{
		for(String word : words.keySet())
		{
			if(words.get(word) == 1)
			{
				System.out.println("The word '" + word + "' appears " + words.get(word) + " time in the selected file.");
			}
			else
			{
				System.out.println("The word '" + word + "' appears " + words.get(word) + " times in the selected file.");
			}
		}
	}
}