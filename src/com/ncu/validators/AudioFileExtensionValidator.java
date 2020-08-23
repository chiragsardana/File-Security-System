package com.ncu.validators;
import com.ncu.exceptions.AudioFileExtensionException;
import java.io.*;
import java.util.*;
public class AudioFileExtensionValidator
{
	public static boolean audioFileExtensionValidator(String fileName)
	{
		Properties prop = new Properties();
		FileInputStream input=null;
		try
		{
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");
			prop.load(input);
			AudioOnly(fileName);
		}
		catch(AudioFileExtensionException e)
		{
			String s=prop.getProperty("AudioFileExtensionExceptionMessage");
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
	private static void AudioOnly(String fileName) throws AudioFileExtensionException//checks whether file name conatins .txt entension or not
	{
		String[] name = fileName.split("\\.");		
		if(name[1].equals("wav")==true || name[1].equals("WAV")==true)
		{
			
		}
		else if(name[1].equals("raw")==true || name[1].equals("RAW")==true)
		{

		}
		else if(name[1].equals("m4a")==true || name[1].equals("M4A")==true)
		{

		}
		else if(name[1].equals("mmf")==true || name[1].equals("MMF")==true)
		{

		}
		else if(name[1].equals("mp3")==true || name[1].equals("MP3")==true)
		{

		}
		else
		{
			throw new AudioFileExtensionException("Audio Only Exception");
		}
	}
}