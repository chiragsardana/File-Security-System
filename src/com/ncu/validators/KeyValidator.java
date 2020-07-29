package com.ncu.validators;
import com.ncu.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
public class KeyValidator
{
	public static boolean KeyValidator(String key)throws Exception
	{
		Properties prop = new Properties();
		FileInputStream input=null;
		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");
			prop.load(input);
			AlphabetCharacter(key);
			numericCharacter(key);
			specialCharacter(key);
			fileLength(key);
		}
		catch(NotContainSpecialCharacterException e)
		{
			String s=prop.getProperty("NotContainSpecialCharacterExceptionMessage");//Searches for the property with the specified key in this property list.
			System.out.println(s);
			return false;
		}
		catch(KeyFileLengthException e)
		{
			String s=prop.getProperty("KeyFileLengthExceptionMessage");
			System.out.println(s);
			return false;
		}
		catch(NotContainNumericCharacterException e)
		{
			String s=prop.getProperty("NotContainNumericCharacterExceptionMessage");//Searches for the property with the specified key in this property list.
			System.out.println(s);
			return false;
		}
		catch(NotContainAlphabetCharacterException e)
		{
			String s=prop.getProperty("NotContainAlphabetCharacterExceptionMessage");//Searches for the property with the specified key in this property list.
			System.out.println(s);
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
	private static void specialCharacter(String fileName) throws NotContainSpecialCharacterException//checks whether file name contains special character or not
	{
		fileName = fileName.split("\\.")[0];
		Pattern  patternGet = Pattern.compile("[@#$%^&(,)_]");
		Matcher check = patternGet.matcher(fileName);
		boolean finalValue = check.find();
		if (finalValue == true)
		{

		}
		else
		{
			throw new NotContainSpecialCharacterException("Not Contain Special Character Exception");
		}
	}
	private static void numericCharacter(String key)throws NotContainNumericCharacterException
	{
		int n=key.length();
		boolean check=false;
		for(int i=0;i<n;i++)
		{
			char c=key.charAt(i);
			if(Character.isDigit(c))
			{
				check=true;
				break;
			}
		}
		if(check==true)
		{

		}
		else
		{
			throw new NotContainNumericCharacterException("Not Contain Numeric Character Exception");
		}
	}
	private static void AlphabetCharacter(String key)throws NotContainAlphabetCharacterException
	{
		int n=key.length();
		boolean check=false;
		for(int i=0;i<n;i++)
		{
			int c=(int)(key.charAt(i));//ascii value...
			if(c>=65 && c<=122)
			{
				check=true;
				break;
			}
		}
		if(check==true)
		{

		}
		else
		{
			throw new NotContainAlphabetCharacterException("Not Contain Alphabet Character Exception");
		}
	}
	private static void fileLength(String fileName)throws KeyFileLengthException//check whether the length is greator than 25
	{
		int fileLength=16;
		String namelength = fileName.split("\\.")[0];
		if(namelength.length()==fileLength)
		{
			
		}
		else
		{
			throw new KeyFileLengthException("Key File Length Exception");
		}
	}
}