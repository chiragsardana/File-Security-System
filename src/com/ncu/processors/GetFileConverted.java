package com.ncu.processors;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
public class GetFileConverted//file\\
{
	public static byte[] getFileConverted(String fileName,String extension,String depends)//it converts normal file into byte array 
    {
    	//it contains file name and extension name...
    	//C:\Users\chira\Desktop\File Security System\file which u want to encrypt
        File f = new File("..\\File Security System\\"+depends+fileName+"."+extension);
        InputStream is = null;
        try 
        {
            is = new FileInputStream(f);
        } 
        catch (FileNotFoundException e2) 
        {
            System.out.print("");
        }
        byte[] content = null;
        try 
        {
            content = new byte[is.available()];
        } 
        catch (IOException e1) 
        {
            System.out.print("");
        }
        try 
        {
            is.read(content);//read() method reads the next byte of the data from 
            				//the the input stream and returns int in the range of 0 to 255...
        } 
        catch (IOException e) 
        {
            System.out.print("");
        }

        return content;
    }
}