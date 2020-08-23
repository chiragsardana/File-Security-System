package com.ncu.validators;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import com.ncu.exceptions.TextFileExtensionException;
public class TextFileExtensionValidator
{
	public static boolean textFileExtensionValidator(String fileName)
	{
		Properties prop = new Properties();
		FileInputStream input=null;
		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");
			prop.load(input);
			txtOnly(fileName);
		}
		catch(TextFileExtensionException e)
		{
			String s=prop.getProperty("TextFileExtensionExceptionMessage");
			System.out.println(s);
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}
	private static void txtOnly(String fileName) throws TextFileExtensionException//checks whether file name conatins .txt entension or not
	{
		String[] name = fileName.split("\\.");		
		if(name[1].equals("txt")==true)
		{
			
		}
		else
		{
			throw new TextFileExtensionException("Txt Only Exception");
		}
	}
}