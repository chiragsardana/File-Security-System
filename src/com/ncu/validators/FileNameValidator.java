package com.ncu.validators;
import com.ncu.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
public class FileNameValidator//i have to change the class name to NameValidator...
{
	public static boolean FileNameValidator(String fileName)
	{
		Properties prop = new Properties();
		FileInputStream input=null;
		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");
			prop.load(input);
			emptyFileName(fileName);
			missingDot(fileName);
			fileLength(filename);
			fileFormat(filename);
			specialCharacter(filename);
			fileExist(fileName);
		}
		catch(FileExistException e)
		{
			String s=prop.getProperty("FileExistExceptionMessage");
			System.out.println(s);
			return false;	
		}
		catch(EmptyFileNameException e)
		{
			String s=prop.getProperty("EmptyFileNameExceptionMessage");//Searches for the property with the specified key in this property list.
			System.out.println(s);
			return false;
		}
		catch(MissingExtensionException e)
		{
			String s=prop.getProperty("MissingExtensionExceptionMessage");
			System.out.println(s);
			return false;
		}
		catch(FileLengthException e)
		{
			String s=prop.getProperty("FileLengthExceptionMessage");
			System.out.println(s);
			return false;

		}
		catch(FileFormatException e)
		{
			String s=prop.getProperty("FileFormatExceptionMessage");
			System.out.println(s);
			return false;
		}
		catch(SpecialCharacterException e)
		{
			String s=prop.getProperty("SpecialCharacterExceptionMessage");
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
	private void emptyFileName(String filename)throws EmptyFileNameException
	{
		if (filename.equals(""))
			throw new EmptyFileNameException("Empty File Name Exception");
	}
	private void missingDot(String fileName)throws MissingExtensionException//check whether file name contains dot or not
	{
		Pattern costPattern = Pattern.compile("[.]");
		Matcher costMatcher = costPattern.matcher(fileName);
		boolean value = costMatcher.find();
		if (value==true)
		{

		}
		else
		{
			throw new MissingExtensionException("Missing Extension Exception");
		}			
	}
	private void fileFormat(String fileName) throws FileFormatException//checks whether file name contains extension or not
	{
		String [] extn = fileName.split("\\.");
		if (extn.length<=1) 
		{
			throw new FileFormatException("File Format Exception");
		}
	}
	private void specialCharacter(String fileName) throws SpecialCharacterException//checks whether file name contains special character or not
	{
		fileName = fileName.split("\\.")[0];
		Pattern  patternGet = Pattern.compile("[@#$%^&(,)_]");
		Matcher check = patternGet.matcher(fileName);
		boolean finalValue = check.find();
		if (finalValue == true)
			throw new SpecialCharacterException("Special Character Exception");
	}
	private void fileLength(String fileName)throws FileLengthException//check whether the length is greator than 25
	{
		int fileLength=25;
		String namelength = fileName.split("\\.")[0];
		if(namelength.length()>fileLength)
		{
			throw new FileLengthException("File Length Exception");
		}
	}
	private void fileExist(String fileName) throws Exception
	{
		File f = new File(fileName);
		if(f.exists()==true)
		{

		}
		else
		{
			throw new FileExistException("File Exist Exception");
		}
	}
}