package com.ncu.validators;
import com.ncu.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
public class TextFileExtensionValidator
{
	public static boolean TextFileExtensionValidator(String fileName)
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
	private void txtOnly(String fileName) throws TextFileExtensionException//checks whether file name conatins .txt entension or not
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