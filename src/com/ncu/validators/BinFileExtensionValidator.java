package com.ncu.validators;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import com.ncu.exceptions.BinFileExtensionException;
public class BinFileExtensionValidator
{
	public static boolean binFileExtensionValidator(String fileName)
	{
		Properties prop = new Properties();
		FileInputStream input=null;
		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");
			prop.load(input);
			binOnly(fileName);
		}
		catch(BinFileExtensionException e)
		{
			String s=prop.getProperty("BinFileExtensionExceptionMessage");
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
	private static void binOnly(String fileName) throws BinFileExtensionException//checks whether file name conatins .txt entension or not
	{
		String[] name = fileName.split("\\.");		
		if(name[1].equals("bin")==true)
		{
			
		}
		else
		{
			throw new BinFileExtensionException("Bin Only Exception");
		}
	}
}