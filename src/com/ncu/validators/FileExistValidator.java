package com.ncu.validators;
import com.ncu.exceptions.*;
import java.io.*;
import java.util.*;
public class FileExistValidator//check whether file exists or not...
{
	public static boolean fileExistValidator(String fileName,String depends)
	{
		Properties prop = new Properties();
		FileInputStream input=null;

		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");//i want to check this line
			prop.load(input);
			File f = new File("..\\File Security System\\"+depends+fileName);
			if(f.exists()==true)
			{

			}
			else
			{
			throw new FileExistException("File Exist Exception");
			}
		}
		catch(FileExistException e)
		{
			String s=prop.getProperty("FileExistExceptionMessage");
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
}