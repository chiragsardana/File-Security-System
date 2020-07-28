package com.ncu.processors;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
public class GetFileConverted//file\\
{
	public static byte[] getFileConverted(String fileName,String extension,String depends)throws Exception//it converts normal file into byte array 
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
            e2.printStackTrace();
        }
        byte[] content = null;
        try 
        {
            content = new byte[is.available()];
        } 
        catch (IOException e1) 
        {
            e1.printStackTrace();
        }
        try 
        {
            is.read(content);//read() method reads the next byte of the data from 
            				//the the input stream and returns int in the range of 0 to 255...
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        return content;
    }
}