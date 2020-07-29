package com.ncu.validators;
import com.ncu.exceptions.*;
import java.io.*;
import java.util.*;
public class ImageFileExtensionValidator
{
	public static boolean ImageFileExtensionValidator(String fileName)
	{
		Properties prop = new Properties();
		FileInputStream input=null;
		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");
			prop.load(input);
			ImageOnly(fileName);
		}
		catch(ImageFileExtensionException e)
		{
			String s=prop.getProperty("ImageFileExtensionExceptionMessage");
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
	private void ImageOnly(String fileName) throws ImageFileExtensionException//checks whether file name conatins .txt entension or not
	{
		String[] name = fileName.split("\\.");		
		if(name[1].equals("jpg")==true || name[1].equals("JPG")==true)
		{
			
		}
		else if(name[1].equals("PNG")==true || name[1].equals("png")==true)
		{

		}
		else if(name[1].equals("GIF")==true || name[1].equals("gif")==true)
		{

		}
		else if(name[1].equals("PSD")==true || name[1].equals("psd")==true)
		{

		}
		else if(name[1].equals("RAW")==true || name[1].equals("raw")==true)
		{

		}
		else
		{
			throw new ImageFileExtensionException("Image Only Exception");
		}
	}
}