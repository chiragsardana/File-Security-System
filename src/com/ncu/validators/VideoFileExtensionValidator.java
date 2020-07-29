package com.ncu.validators;
import com.ncu.exceptions.VideoFileExtensionException;
import java.io.*;
import java.util.*;
public class VideoFileExtensionValidator
{
	public static boolean videoFileExtensionValidator(String fileName)
	{
		Properties prop = new Properties();
		FileInputStream input=null;
		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");
			prop.load(input);
			VideoOnly(fileName);
		}
		catch(VideoFileExtensionException e)
		{
			String s=prop.getProperty("VideoFileExtensionExceptionMessage");
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
	private static void VideoOnly(String fileName) throws VideoFileExtensionException//checks whether file name conatins .txt entension or not
	{
		String[] name = fileName.split("\\.");		
		if(name[1].equals("webm")==true || name[1].equals("WEBM")==true)
		{
			
		}
		else if(name[1].equals("mkv")==true || name[1].equals("MKV")==true)
		{

		}
		else if(name[1].equals("GIF")==true || name[1].equals("gif")==true)
		{

		}
		else if(name[1].equals("avi")==true || name[1].equals("AVI")==true)
		{

		}
		else if(name[1].equals("mp4")==true || name[1].equals("MP4")==true)
		{

		}
		else
		{
			throw new VideoFileExtensionException("Video Only Exception");
		}
	}
}