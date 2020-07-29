package com.ncu.validators;
import com.ncu.exceptions.DocumentFileExtensionException;
import java.io.*;
import java.util.*;
public class DocumentFileExtensionValidator
{
	public static boolean documentFileExtensionValidator(String fileName)
	{
		Properties prop = new Properties();
		FileInputStream input=null;
		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");
			prop.load(input);
			DocumentOnly(fileName);
		}
		catch(DocumentFileExtensionException e)
		{
			String s=prop.getProperty("DocumentFileExtensionExceptionMessage");
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
	private static void DocumentOnly(String fileName) throws DocumentFileExtensionException//checks whether file name conatins .txt entension or not
	{
		String[] name = fileName.split("\\.");		
		if(name[1].equals("pdf")==true || name[1].equals("PDF")==true)
		{
			
		}
		else if(name[1].equals("ppt")==true || name[1].equals("PPT")==true)
		{

		}
		else if(name[1].equals("doc")==true || name[1].equals("DOC")==true)
		{

		}
		else if(name[1].equals("docx")==true || name[1].equals("DOCX")==true)
		{

		}
		else if(name[1].equals("rtf")==true || name[1].equals("RTF")==true)
		{

		}
		else
		{
			throw new DocumentFileExtensionException("Document Only Exception");
		}
	}
}