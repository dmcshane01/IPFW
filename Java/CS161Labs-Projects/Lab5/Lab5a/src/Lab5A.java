/*
 * Daniel DelyMcShane
 * CS161
 * Lab5 Part A
 * 2/26/2016
 * 
 * Program reads in a sample txt file and counts the number of words, sentences, and vowels
 */

import java.util.*;
import java.io.*;

public class Lab5A {

	public static void main(String[] args) throws FileNotFoundException {

		File text = new File("Sample.txt");
		Scanner in = new Scanner(text);
		
		String word;
		int wordCount = 0;
		int sentenceCount = 0;
		int aCount = 0;
		int eCount = 0;
		int iCount = 0;
		int oCount = 0;
		int uCount = 0;
		
		//get word count
		while(in.hasNextLine())
		{
			if(in.hasNext())
			{
				word = in.next();
				wordCount++;
				
				for(int i = 0; i < word.length(); i++)
				{
					if(word.charAt(i) == '.')
					{
						sentenceCount++;
					}
					if(word.charAt(i) == 'a')
					{
						aCount++;
					}
					if(word.charAt(i) == 'e')
					{
						eCount++;
					}
					if(word.charAt(i) == 'i')
					{
						iCount++;
					}
					if(word.charAt(i) == 'o')
					{
						oCount++;
					}
					if(word.charAt(i) == 'u')
					{
						uCount++;
					}
				}

			}
		}
		
		in.close();
		
		System.out.println("Total number of Sentences = " + sentenceCount);
		System.out.println("Total number of words = " + wordCount);
		System.out.println("The frequency of char a = " + aCount);
		System.out.println("The frequency of char e = " + eCount);
		System.out.println("The frequency of char i = " + iCount);
		System.out.println("The frequency of char o = " + oCount);
		System.out.println("The frequency of char u = " + uCount);






	}

}
